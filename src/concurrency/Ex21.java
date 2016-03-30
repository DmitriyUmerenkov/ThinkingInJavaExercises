package concurrency;

import java.util.concurrent.*;

class First implements Runnable {

	@Override
	public void run() {
		synchronized(this) {

		try {
		wait();
		} catch (Exception e) {}
		System.out.println("First!");
		}
	}
	
}


class Second implements Runnable {
	First first;
	
	Second (First first) {this.first=first;}
	
	@Override
	public void run() {
		synchronized(first) {
		first.notifyAll();
		}
		
	}
	
	
}

public class Ex21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		First first=new First();
		Second second= new Second(first);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(first);
		exec.execute(second);
		exec.shutdown();
		
	}

}
