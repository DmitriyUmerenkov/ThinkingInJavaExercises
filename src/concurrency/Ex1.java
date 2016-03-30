package concurrency;

import java.util.concurrent.*;

public class Ex1 implements Runnable{
    static int counter=0;
	final int id=counter++;
	
	Ex1(){System.out.println("Constructing process # "+ id);} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService exec1 = Executors.newCachedThreadPool();
		ExecutorService exec2 = Executors.newFixedThreadPool(10);
		ExecutorService exec3 = Executors.newSingleThreadExecutor();
		ExecutorService exec4 = Executors.newWorkStealingPool();
		ExecutorService exec5 = Executors.newSingleThreadScheduledExecutor();
		
		for (int i=0;i<5;i++)
		{
//			new Thread(new Ex1()).start();;
			exec1.execute(new Ex1());
		    exec2.execute(new Ex1());
		    exec3.execute(new Ex1());
		    exec4.execute(new Ex1());
		    exec5.execute(new Ex1());
		}	
	}

	@Override
	public void run() {
		for (int i=0;i<3;i++) {
			System.out.println("Process:"+ id +" Iteration: "+i);
			Thread.yield();
		}
		System.out.println("Process #" +id + " terminated");
	}

}
