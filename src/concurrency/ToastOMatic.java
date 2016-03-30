package concurrency;

import java.util.concurrent.*;
import java.util.*;
import static util.Print.*;
class Toast {
  public enum Status { DRY, BUTTERED, JAMMED, PBUTTERED, JELLIED }
  private Status status = Status.DRY;
  private final int id;
  public Toast(int idn) { id = idn; }
  public void butter() { status = Status.BUTTERED; }
  public void jam() { status = Status.JAMMED; }
  public void pbutter() { status = Status.PBUTTERED; }
  public void jelly() { status = Status.JELLIED; }

  public Status getStatus() { return status; }
  public int getId() { return id; }
  public String toString() {
    return "Toast " + id + ": " + status;
  }
}
class ToastQueue extends LinkedBlockingQueue<Toast> {}

class Toaster implements Runnable {

  Toaster(ToastQueue tq, int count) {toastQueue = tq; this.count=count;}
  private ToastQueue toastQueue;
  private int count = 0;
  private Random rand = new Random(47);
  public Toaster(ToastQueue tq) { toastQueue = tq; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        TimeUnit.MILLISECONDS.sleep(
          100 + rand.nextInt(500));
        // Make toast
        Toast t = new Toast(count++);
        print(t);
        // Insert into queue
        toastQueue.put(t);
      }
    } catch(InterruptedException e) {
      print("Toaster interrupted");
      }
    print("Toaster off");
  }
}
// Apply butter to toast:
class Butterer implements Runnable {
  private ToastQueue dryQueue, butteredQueue;
  public Butterer(ToastQueue dry, ToastQueue buttered) {
    dryQueue = dry;
    butteredQueue = buttered;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until next piece of toast is available:
        Toast t = dryQueue.take();
        t.butter();
        print(t);
        butteredQueue.put(t);
      }
    } catch(InterruptedException e) {
      print("Butterer interrupted");
    }
    print("Butterer off");
  }
}
// Apply jam to buttered toast:
class Jammer implements Runnable {
  private ToastQueue butteredQueue, finishedQueue;
  public Jammer(ToastQueue buttered, ToastQueue finished) {
    butteredQueue = buttered;
    finishedQueue = finished;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until next piece of toast is available:
        Toast t = butteredQueue.take();
        t.jam();
        print(t);
        finishedQueue.put(t);
      }
    } catch(InterruptedException e) {
      print("Jammer interrupted");
    }
    print("Jammer off");
  }
}

class PButterer implements Runnable {
	  private ToastQueue dryQueue, butteredQueue;
	  public PButterer(ToastQueue dry, ToastQueue buttered) {
	    dryQueue = dry;
	    butteredQueue = buttered;
	  }
	  public void run() {
	    try {
	      while(!Thread.interrupted()) {
	        // Blocks until next piece of toast is available:
	        Toast t = dryQueue.take();
	        t.pbutter();;
	        print(t);
	        butteredQueue.put(t);
	      }
	    } catch(InterruptedException e) {
	      print("PButterer interrupted");
	    }
	    print("PButterer off");
	  }
	}
	// Apply jam to buttered toast:
	class Jellier implements Runnable {
		Random rand = new Random();
	  private ToastQueue butteredQueue, finishedQueue;
	  public Jellier(ToastQueue buttered, ToastQueue finished) {
	    butteredQueue = buttered;
	    finishedQueue = finished;
	  }
	  public void run() {
	    try {
	      while(!Thread.interrupted()) {
	        // Blocks until next piece of toast is available:
	    	   TimeUnit.MILLISECONDS.sleep(
	    		          100 + rand.nextInt(500));
	    	  Toast t = butteredQueue.take();
	        t.jelly();;
	        print(t);
	        finishedQueue.put(t);
	      }
	    } catch(InterruptedException e) {
	      print("Jellier interrupted");
	    }
	    print("Jellier off");
	  }
	}

// Consume the toast:
class Eater implements Runnable {
  private ToastQueue finishedQueue;
  private int counter = 0;
  public Eater(ToastQueue finished) {
    finishedQueue = finished;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until next piece of toast is available:
        Toast t = finishedQueue.take();
        // Verify that the toast is coming in order,
        // and that all pieces are getting jammed:
     //   if(t.getId() != counter++ ||
     //      t.getStatus() != Toast.Status.JAMMED) {
     //     print(">>>> Error: " + t);
     //     System.exit(1);
     //   } else
          print("Chomp! " + t);
      }
    } catch(InterruptedException e) {
      print("Eater interrupted");
    }
    print("Eater off");
  }
}
public class ToastOMatic {
  public static void main(String[] args) throws Exception {
    ToastQueue dryQueue = new ToastQueue(),
               butteredQueue = new ToastQueue(),
               finishedQueue = new ToastQueue(),
    		   pbutteredQueue = new ToastQueue(),
    		   dryQueue2 = new ToastQueue();
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(new Toaster(dryQueue));
    exec.execute(new Toaster(dryQueue2, 100));
    
    exec.execute(new Butterer(dryQueue, butteredQueue));
    exec.execute(new PButterer(dryQueue2, pbutteredQueue));

    exec.execute(new Jammer(butteredQueue, finishedQueue));
    exec.execute(new Jellier(pbutteredQueue, finishedQueue));
    
    exec.execute(new Eater(finishedQueue));
    TimeUnit.SECONDS.sleep(5);
    exec.shutdownNow();
  }
}