package concurrency;

import java.util.concurrent.*;

class Tasker {
	void task() {
		System.out.println("Starting task");
		try{
		TimeUnit.SECONDS.sleep(100);
		}
		catch (InterruptedException e) {System.out.println("Task interrupted");}
				System.out.println("Ending task");		
	}
}


class Caller implements Runnable {

	@Override
	public void run() {
		System.out.println("Stating Caller");
		new Tasker().task();
		System.out.println("Ending Caller");		
	}
}

public class Ex18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Caller());
		try {
		TimeUnit.SECONDS.sleep(1);;
		}
		catch (Exception e) {}
		System.out.println("Shutting down main");
		exec.shutdownNow();
	}

}
