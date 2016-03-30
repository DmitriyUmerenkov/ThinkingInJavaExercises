package concurrency;

import java.util.concurrent.*;
import static util.Print.*;
import java.util.*;
import java.util.concurrent.locks.*;

class Meal {
private final int orderNum;
  public Meal(int orderNum) { this.orderNum = orderNum; }
  public String toString() { return "Meal " + orderNum; }
}
class Table {
private final int tableNum;
	  public Table(int tableNum) { this.tableNum = tableNum; }
	  public String toString() { return "Table " + tableNum; }	
}

class WaitPerson implements Runnable {
  private Restaurant restaurant;
  public WaitPerson(Restaurant r) { restaurant = r; }
  Random rand = new Random();
  public void run() {
    try {
      while(!Thread.interrupted()) {
       
    	  restaurant.waitPersonLock.lock(); try {
          while(restaurant.meal == null)
           restaurant.waitPersonCondition.await(); // ... for the chef to produce a meal
        } finally {restaurant.waitPersonLock.unlock();}
        print("Waitperson got " + restaurant.meal);
        restaurant.chefLock.lock(); try{
          restaurant.meal = null;
          
          restaurant.chefCondition.signalAll(); // Ready for another
        } finally { restaurant.chefLock.unlock();}
        restaurant.busBoyLock.lock();
  	  
  	  try {
            restaurant.table = new Table(rand.nextInt(10));
            System.out.println("Waitperson set up table # "+restaurant.table);
            restaurant.busBoyCondition.signalAll(); // Ready for another
          } finally {restaurant.busBoyLock.unlock();}        
      }
    } catch(InterruptedException e) {
      print("WaitPerson interrupted");
    }
} }

class BusBoy implements Runnable {
	private Restaurant restaurant;
	  public BusBoy(Restaurant r) { restaurant = r; }
	@Override
	public void run() {
		 try {
		      while(!Thread.interrupted()) {
		        
		    	  restaurant.busBoyLock.lock();
		    	  try {
		        	 while(restaurant.table == null)
		        		 restaurant.busBoyCondition.await();
		        	 System.out.println("Busboy clearing "+ restaurant.table);
		        	 restaurant.table=null;
		        } finally {restaurant.busBoyLock.unlock();}
		  }
		  } catch(InterruptedException e) {
		      print("BusBoy interrupted");
		    }
	}
}


class Chef implements Runnable {
  private Restaurant restaurant;
  private int count = 0;
  public Chef(Restaurant r) { restaurant = r; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        restaurant.chefLock.lock(); try {
          while(restaurant.meal != null)
            restaurant.chefCondition.await(); // ... for the meal to be taken
        } finally {restaurant.chefLock.unlock();}
        if(++count == 10) {
          print("Out of food, closing");
          restaurant.exec.shutdownNow();
          return;
        }
        printnb("Order up! ");
        restaurant.waitPersonLock.lock(); try {
          restaurant.meal = new Meal(count);
          restaurant.waitPersonCondition.signalAll();
        } finally {restaurant.waitPersonLock.unlock();}
        TimeUnit.MILLISECONDS.sleep(100);
      }
    } catch(InterruptedException e) {
      print("Chef interrupted");
    }
} }
public class Restaurant {
  Meal meal;
  Table table;
  ExecutorService exec = Executors.newCachedThreadPool();
  WaitPerson waitPerson = new WaitPerson(this);
  Lock chefLock = new ReentrantLock();
  Condition chefCondition =chefLock.newCondition();
  Lock busBoyLock = new ReentrantLock();
  Condition busBoyCondition =busBoyLock.newCondition();
  Lock waitPersonLock = new ReentrantLock();
  Condition waitPersonCondition = waitPersonLock.newCondition();
 
  
  Chef chef = new Chef(this);
  BusBoy busboy = new BusBoy(this);
  public Restaurant() {
    exec.execute(chef);
    exec.execute(waitPerson);
    exec.execute(busboy);
    }
  public static void main(String[] args) {
    new Restaurant();
  }
}
