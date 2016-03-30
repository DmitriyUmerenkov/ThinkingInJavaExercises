package concurrency;

import java.util.*;
import java.util.concurrent.*;

class Sensor implements Runnable {
	
	Sensor (RadCounter master) {this.master=master;}
	
	int localCounter;
	RadCounter master;
	Random r = new Random();
	boolean canceled=false;
	
	void cancel() {canceled = true;}
	
	void increment(int val) {localCounter+=val; master.IncrementCounter(val);}
	
	@Override
	public void run() {
		while(!canceled) {
			increment(r.nextInt(20));
			try {Thread.sleep(200);} catch (Exception e) {}
		}
		System.out.println("Sensor finished, local count="+ localCounter);
	
	}
}

class RadCounter {
	
	synchronized void IncrementCounter(int val) {globalCounter+=val;}
	int globalCounter;
	
	List<Sensor> sensors = new ArrayList<Sensor>();
	void addSensor() {sensors.add(new Sensor(this));}
	int getRadCount (){return globalCounter;}
	void terminate() {for (Sensor s: sensors) s.cancel();}	
	
}



public class Ex17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RadCounter counter = new RadCounter();
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for (int i=0; i<5; i++) counter.addSensor();

		for (Sensor s: counter.sensors) exec.execute(s);
		
		try {TimeUnit.SECONDS.sleep(3);} catch (Exception e) {}
		counter.terminate();
		System.out.println("Counter terminated, total count="+counter.getRadCount());
	}

}
