package concurrency;

import java.util.concurrent.*;
import java.util.*;
//Read-only objects don’t require synchronization:
class WebRequest {
private final int serviceTime;
final long creationTime;
public WebRequest(int tm) { serviceTime = tm; creationTime =System.nanoTime();}
public int getServiceTime() { return serviceTime; }
public String toString() {
 return "[" + serviceTime + "]";
}
}
//Teach the customer line to display itself:
class WebRequestLine extends ArrayBlockingQueue<WebRequest> {
public WebRequestLine(int maxLineSize) {
 super(maxLineSize);
}
public String toString() {
 if(this.size() == 0)
   return "[Empty]";
 StringBuilder result = new StringBuilder();
 for(WebRequest request : this)
   result.append(request);
 return result.toString();
} }
//Randomly add customers to a queue:
class WebRequestGenerator implements Runnable {
private WebRequestLine requests;
private static Random rand = new Random(47);
public WebRequestGenerator(WebRequestLine cq) {
	requests = cq;
}
public void run() {
	  try{
		  while(!Thread.interrupted()) {
 TimeUnit.MILLISECONDS.sleep(rand.nextInt(100));
 requests.put(new WebRequest(rand.nextInt(1000)));
}
} catch(InterruptedException e) {
System.out.println("WebRequestGenerator interrupted");
}
System.out.println("WebRequestGenerator terminating");
}
}

class Server implements Runnable, Comparable<Server> {
private static int counter = 0;
private final int id = counter++;
//Customers served during this shift:
private int webRequestsServed = 0;
private WebRequestLine requests;
private boolean servingWebRequestLine = true;
public Server(WebRequestLine cq) { requests = cq; }
public void run() {
try {
while(!Thread.interrupted()) {
	WebRequest request = requests.take();
	System.out.println("Request time till service "+ TimeUnit.MILLISECONDS.convert(System.nanoTime()-request.creationTime, TimeUnit.NANOSECONDS));
 TimeUnit.MILLISECONDS.sleep(
   request.getServiceTime());
 synchronized(this) {
	 webRequestsServed++;
   while(!servingWebRequestLine)
wait(); }
}
} catch(InterruptedException e) {
System.out.println(this + "interrupted");
}
System.out.println(this + "terminating");
}
public synchronized void doSomethingElse() {
	webRequestsServed = 0;
	servingWebRequestLine = false;
}
public synchronized void serveCustomerLine() {
assert !servingWebRequestLine:"already serving: " + this;
servingWebRequestLine = true;
notifyAll();
}
public String toString() { return "Teller " + id + " "; }
public String shortString() { return "T" + id; }
//Used by priority queue:
public synchronized int compareTo(Server other) {
return webRequestsServed < other.webRequestsServed ? -1 :
(webRequestsServed == other.webRequestsServed ? 0 : 1);
} }
class ServerManager implements Runnable {
private ExecutorService exec;
private WebRequestLine requests;
private PriorityQueue<Server> workingServers =
new PriorityQueue<Server>();
private Queue<Server> serversDoingOtherThings =
new LinkedList<Server>();
private int adjustmentPeriod;
private static Random rand = new Random(47);
public ServerManager(ExecutorService e,
WebRequestLine requests, int adjustmentPeriod) {
exec = e;
this.requests = requests;
this.adjustmentPeriod = adjustmentPeriod;
//Start with a single teller:
Server server = new Server(requests);
exec.execute(server);
workingServers.add(server);
}
public void adjustServerNumber() {
//This is actually a control system. By adjusting
//the numbers, you can reveal stability issues in
//the control mechanism.
//If line is too long, add another teller:
if(requests.size() / workingServers.size() > 2) {
 // If tellers are on break or doing
 // another job, bring one back:
 if(serversDoingOtherThings.size() > 0) {
   Server server = serversDoingOtherThings.remove();
   server.serveCustomerLine();
   workingServers.offer(server);
   return;
 }
// Else create (hire) a new teller
if (workingServers.size()+serversDoingOtherThings.size()< WebServersLoadSimulation.MAX_SERVERS)
{
 Server server = new Server(requests);
 exec.execute(server);
 workingServers.add(server);
}
return;
}
//If line is short enough, remove a teller:
if(workingServers.size() > 1 &&
		requests.size() / workingServers.size() < 2)
 reassignOneTeller();
//If there is no line, we only need one teller:
if(requests.size() == 0)
while(workingServers.size() > 1)
 reassignOneTeller();
}
//Give a teller a different job or a break:
private void reassignOneTeller() {
Server server = workingServers.poll();
server.doSomethingElse();
serversDoingOtherThings.offer(server);
}
public void run() {
try {
while(!Thread.interrupted()) {
 TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
 adjustServerNumber();
 System.out.print(requests + " { ");
 for(Server server : workingServers)
   System.out.print(server.shortString() + " ");
 System.out.println("}");
}
} catch(InterruptedException e) {
System.out.println(this + "interrupted");
}
System.out.println(this + "terminating");
}
public String toString() { return "TellerManager "; }
}
public class WebServersLoadSimulation {
static final int MAX_LINE_SIZE = 500;
static final int ADJUSTMENT_PERIOD = 1000;
static final int MAX_SERVERS = 50;
public static void main(String[] args) throws Exception {
ExecutorService exec = Executors.newCachedThreadPool();
//If line is too long, customers will leave:
WebRequestLine requests =
new WebRequestLine(MAX_LINE_SIZE);
exec.execute(new WebRequestGenerator(requests));
//Manager will add and remove tellers as necessary:
exec.execute(new ServerManager(
exec, requests, ADJUSTMENT_PERIOD));
if(args.length > 0) // Optional argument
TimeUnit.SECONDS.sleep(new Integer(args[0]));
else {
System.out.println("Press ‘Enter’ to quit");
System.in.read();
}
exec.shutdownNow();
}
}

