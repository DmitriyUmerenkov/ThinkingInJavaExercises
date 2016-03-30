package concurrency;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex6 implements Runnable {
	Random rand = new Random();
	static int counter;
	final int id=counter++;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i=0;i< Integer.parseInt(args[0]) ;i++)
			exec.execute(new Ex6());
	}

	@Override
	public void run() {
		int sleeper = rand.nextInt(1000);
		try { TimeUnit.MILLISECONDS.sleep(sleeper);
		System.out.println("Process "+ id+ " slept for "+ sleeper +" ms");
		}
		catch (Exception e) {}
		
		}

}
