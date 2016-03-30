package concurrency;

import java.util.concurrent.*;


class HighPriorityThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread t = new Thread(r);
		t.setPriority(Thread.MAX_PRIORITY);
		return t;
		
	}
	}

class LowPriorityThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread t = new Thread(r);
		t.setPriority(Thread.MIN_PRIORITY);
		return t;
		
	}
	}


public class SimplePriorities implements Runnable {
  private int countDown = 5;
  private volatile double d; // No optimization
  private int priority;
  public SimplePriorities() {

  }
  public String toString() {
    return Thread.currentThread() + ": " + countDown;
  }
  public void run() {
   // Thread.currentThread().setPriority(priority);
    while(true) {
      // An expensive, interruptable operation:
      for(int i = 1; i < 100000; i++) {
        d += (Math.PI + Math.E) / (double)i;
        if(i % 1000 == 0)
          Thread.yield();
      }
      System.out.println(this);
      if(--countDown == 0) return;
    }
  }
  public static void main(String[] args) {
    ExecutorService exechigh = Executors.newCachedThreadPool(new HighPriorityThreadFactory());
    ExecutorService execlow = Executors.newCachedThreadPool(new LowPriorityThreadFactory());

    exechigh.execute(
            new SimplePriorities());

    for(int i = 0; i < 5; i++)
      execlow.execute(
        new SimplePriorities());
    exechigh.shutdown();
    execlow.shutdown();
  }
}
