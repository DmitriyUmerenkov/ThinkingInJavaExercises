package concurrency;

import java.util.concurrent.*;

class Sleeper implements Runnable {
	volatile boolean sleepFlag=false;
	
	@Override
	public void run() {
		
		try {
			synchronized (this) {
	        System.out.println("Before sleep");
			TimeUnit.SECONDS.sleep(1);		
			System.out.println("Setting flag");
			notifyAll();
			sleepFlag=true;}
		} catch (Exception e) {}

	}
}


class Watcher implements Runnable {
	Sleeper sleepo;
	Watcher(Sleeper sleepo) {this.sleepo=sleepo;}
	@Override

	public void run() {
		// TODO Auto-generated method stub
		while(sleepo.sleepFlag==false) {
			System.out.println("Waiting...");
			try {
			synchronized (sleepo) {
				wait();
			}
			} catch (Exception e) {}
		}
		if (sleepo.sleepFlag==true)
		{
			sleepo.sleepFlag=false;
			System.out.println("Changed the flag!");
		}

	
	}
	
}


public class Ex22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sleeper sleep1 = new Sleeper();
		Watcher watch = new Watcher(sleep1);
		ExecutorService exec = Executors.newCachedThreadPool();
		
		exec.execute(sleep1);
		exec.execute(watch);
		exec.shutdown();
		
		
	}

}
