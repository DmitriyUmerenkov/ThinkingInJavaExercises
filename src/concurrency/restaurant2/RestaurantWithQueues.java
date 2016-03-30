package concurrency.restaurant2;

import enumerated.menu.*;
import java.util.concurrent.*;
import java.util.*;
import static util.Print.*;

// This is given to the waiter, who gives it to the chef:
class Order { // (A data-transfer object)
	private static int counter = 0;
	private final int id = counter++;
	private final Customer customer;
	private final WaitPerson waitPerson;
	private final Food food;

	public Order(Customer cust, WaitPerson wp, Food f) {
		customer = cust;
		waitPerson = wp;
		food = f;
	}

	public Food item() {
		return food;
	}

	public Customer getCustomer() {
		return customer;
	}

	public WaitPerson getWaitPerson() {
		return waitPerson;
	}

	public Food getFood() {
		return food;
	}

	public String toString() {
		return "Order: " + id + " item: " + food + " for: " + customer + " served by: " + waitPerson;
	}
}

// This is what comes back from the chef:
class Plate {
	private final Order order;
	private final Food food;

	public Plate(Order ord, Food f) {
		order = ord;
		food = f;
	}

	public Order getOrder() {
		return order;
	}

	public Food getFood() {
		return food;
	}

	public String toString() {
		return food.toString();
	}
}

class Customer implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private final WaitPerson waitPerson;
	final List<Order> orderedFood = new LinkedList<Order>();
	Table table;
	// Only one course at a time can be received:
	private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<Plate>();

	public Customer(WaitPerson w, Table t) {
		waitPerson = w;
		table = t;
		for (Course course : Course.values()) {
			orderedFood.add(new Order(this, waitPerson, course.randomSelection()));
		}
	}

	public void deliver(Plate p) throws InterruptedException {
		// Only blocks if customer is still
		// eating the previous course:
		placeSetting.put(p);
	}

	public void run() {
		for (Order o : orderedFood) {
			// print(this + "waiting for " + o.getFood());
			try {
				// Blocks until course has been delivered:
				print(this + "eating " + placeSetting.take());
			} catch (InterruptedException e) {
				print(this + "waiting for " + o.getFood() + " interrupted");
				break;
			}
		}
		print(this + "finished meal, leaving");
		table.customers.remove(this);
	}

	public String toString() {
		return "Customer " + id + " ";
	}
}

class Table {
	private static int counter;
	final int id = counter++;
	private Restaurant restaurant;
	private boolean isBusy = false;
	List<Customer> customers;
	OrderTicket orderTicket;

	Table(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	boolean isBusy() {
		return isBusy;
	}

	void occupy(Customer... customers) {
		this.customers = new ArrayList<Customer>();
		for (Customer c : customers)
			this.customers.add(c);
		this.isBusy = true;
		print(this + "occupied by" + Arrays.toString(customers));
	}

	void vacate() {
		print(this + " vacated");
		isBusy = false;
	}

	public String toString() {
		return "Table #" + id;

	}

}

class OrderTicket extends HashMap<Customer, List<Order>> {
	OrderTicket(Table t) {
		super();
		this.table = t;
	}

	private static int counter = 0;
	private final int id = counter++;
	Table table;

	void addCustomerOrder(Customer c, Order... orders) {
		List<Order> corder = new ArrayList<Order>();
		corder.addAll(Arrays.asList(orders));
		this.put(c, corder);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order ticket #" + id + " for " + table + "\n");
		for (Customer c : this.keySet()) {
			sb.append(c + " ordered ");
			sb.append(this.get(c));
			sb.append("\n");
		}
		return sb.toString();
	}
}

class WaitPerson implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private final Restaurant restaurant;
	BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<Plate>();

	public WaitPerson(Restaurant rest) {
		restaurant = rest;
	}

	public OrderTicket getOrderTicket(Table t) {
		OrderTicket newOrder = new OrderTicket(t);
		for (Customer c : t.customers) {
			newOrder.addCustomerOrder(c, c.orderedFood.toArray(new Order[0]));
		}
		print(this + " got an " + newOrder);
		return newOrder;
	}

	public void placeOrderTicket(OrderTicket ord) {

		for (int i = 0; i < 5; i++)
			for (Customer c : ord.keySet())
				placeOrder(c, ord.get(c).get(i).getFood());
	}

	public void placeOrder(Customer cust, Food food) {
		try {
			// Shouldn’t actually block because this is
			// a LinkedBlockingQueue with no size limit:
			restaurant.orders.put(new Order(cust, this, food));
			// print("DEBUG" + this + "placed anorder to kitchen");
		} catch (InterruptedException e) {
			print(this + " placeOrder interrupted");
		}
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until a course is ready
				Plate plate = filledOrders.take();
				print(this + "received " + plate + " delivering to " + plate.getOrder().getCustomer());
				plate.getOrder().getCustomer().deliver(plate);
			}
		} catch (InterruptedException e) {
			print(this + " interrupted");
		}
		print(this + " off duty");
	}

	public String toString() {
		return "WaitPerson " + id + " ";
	}
}

class Chef implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private final Restaurant restaurant;
	private static Random rand = new Random(47);

	public Chef(Restaurant rest) {
		restaurant = rest;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until an order appears:
				Order order = restaurant.orders.take();
				Food requestedItem = order.item();
				// Time to prepare order:
				TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				Plate plate = new Plate(order, requestedItem);
				order.getWaitPerson().filledOrders.put(plate);
			}
		} catch (InterruptedException e) {
			print(this + " interrupted");
		}
		print(this + " off duty");
	}

	public String toString() {
		return "Chef " + id + " ";
	}
}

class Restaurant implements Runnable {
	private List<WaitPerson> waitPersons = new ArrayList<WaitPerson>();
	private List<Chef> chefs = new ArrayList<Chef>();
	private List<Table> tables = new ArrayList<Table>();
	private ExecutorService exec;
	private static Random rand = new Random(47);
	BlockingQueue<Order> orders = new LinkedBlockingQueue<Order>();

	public Restaurant(ExecutorService e, int nWaitPersons, int nChefs, int nTables) {
		exec = e;
		for (int i = 0; i < nWaitPersons; i++) {
			WaitPerson waitPerson = new WaitPerson(this);
			waitPersons.add(waitPerson);
			exec.execute(waitPerson);
		}
		for (int i = 0; i < nChefs; i++) {
			Chef chef = new Chef(this);
			chefs.add(chef);
			exec.execute(chef);
		}
		for (int i = 0; i < nTables; i++) {
			Table table = new Table(this);
			tables.add(table);

		}
	}

	int getEmptyTable() {
		for (Table t : tables)
			if (!t.isBusy())
				return t.id;
			else if (t.customers.size() == 0) {
				t.vacate();
				return t.id;
			}
		return -1;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				if (getEmptyTable() == -1) {
					print("All tables are busy, waiting a bit.");
					TimeUnit.SECONDS.sleep(1);
				} else {

					Table t = tables.get(getEmptyTable());
					int guests = 1 + new Random().nextInt(3);
					print("Setting " + t + " for " + guests + " guests");
					// A new customer arrives; assign a WaitPerson:
					WaitPerson wp = waitPersons.get(rand.nextInt(waitPersons.size()));
					List<Customer> customers = new ArrayList<Customer>();
					for (int i = 0; i < guests; i++) {
						Customer c = new Customer(wp, t);
						customers.add(c);
						exec.execute(c);
					}
					t.occupy(customers.toArray(new Customer[0]));
					wp.placeOrderTicket(wp.getOrderTicket(t));

				}
			}
		} catch (InterruptedException e) {
			print("Restaurant interrupted");
		}
		print("Restaurant closing");
	}
}

public class RestaurantWithQueues {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		Restaurant restaurant = new Restaurant(exec, 5, 2, 3);
		exec.execute(restaurant);
		if (args.length > 0) // Optional argument
			TimeUnit.SECONDS.sleep(new Integer(args[0]));
		else {
			print("Press ‘Enter’ to quit");
			System.in.read();
		}
		exec.shutdownNow();
	}
}