package concurrency;

import java.util.concurrent.*;
public class DeadlockingDiningPhilosophers {
  public static void main(String[] args) throws Exception {
    int ponder = 1;
    if(args.length > 0)
      ponder = Integer.parseInt(args[0]);
    int size = 4;
    if(args.length > 1)
      size = Integer.parseInt(args[1]);
    ExecutorService exec = Executors.newCachedThreadPool();
    Chopstick[] sticks = new Chopstick[size];
   BlockingQueue<Chopstick> bin = new LinkedBlockingQueue<Chopstick>();
    for(int i = 0; i < size; i++)
    	
      bin.add(new Chopstick());
    for(int i = 0; i < size; i++)
      exec.execute(new Philosopher(i, ponder, bin));
    if(args.length == 3 && args[2].equals("timeout"))
      TimeUnit.SECONDS.sleep(5);
    else {
      System.out.println("Press ‘Enter’ to quit");
      System.in.read();
}
    exec.shutdownNow();
  }
}
