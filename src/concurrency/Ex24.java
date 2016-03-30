package concurrency;

import java.util.concurrent.*;
import java.util.*;

class Product {
	int value;
	int getValue() {return value;}
	void setValue(int value) {this.value=value;}
	
}



class Producer implements Runnable {
static Random rand = new Random();
volatile Product storage;
Producer(Product storage) {this.storage=storage;}
	@Override
	public void run() {
		try {
		synchronized(storage) {
		while(true)		
		{
		
		storage.setValue(rand.nextInt(1000));
		System.out.println("Generated new int "+ storage.getValue());
		storage.notify();
		System.out.println("gen: notified and waiting");
		storage.wait();
		System.out.println("gen: awakening");
		
		}	
		}
		} catch (Exception e) {System.out.println("Exiting via exception "+ e);}
		}
	
}

class Consumer implements Runnable {
volatile	Product storage;
Consumer (Product storage) {this.storage=storage;}
	
	@Override
	public void run() {
		try {
			synchronized(storage) {
			while(true)		
			{
			//TimeUnit.MILLISECONDS.sleep(1000);
			System.out.println("Consumed new int "+ storage.getValue());
			storage.notify();
			System.out.println("con: notified and waiting");

			storage.wait();
			System.out.println("con: awakening");
			}	
			}
			} catch (Exception e) {System.out.println("Exiting via exception"+ e);}
	}
	
}


public class Ex24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		Product p=new Product();
		exec.execute(new Producer(p));
		exec.execute(new Consumer(p));
		try {
		TimeUnit.SECONDS.sleep(1);;
		} catch (Exception e) {}
		exec.shutdownNow();
	}

}
