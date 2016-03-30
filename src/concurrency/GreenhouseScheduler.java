package concurrency;

import java.util.concurrent.*;
import java.util.*;
import static java.util.concurrent.TimeUnit.*;



abstract class DelayedRunnable  implements Runnable, Delayed {
	  protected int delta=0;
	  protected long trigger=0;	
	  
public long getDelay(TimeUnit unit) {
	return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
}

public int compareTo(Delayed o) {
	DelayedRunnable that = (DelayedRunnable)o;
    if(trigger < that.trigger) return -1;
    if(trigger > that.trigger) return 1;
    return 0;
} 
}

public class GreenhouseScheduler {
private volatile boolean light = false;
private volatile boolean water = false;
private String thermostat = "Day";
public synchronized String getThermostat() {
  return thermostat;
}
public synchronized void setThermostat(String value) {
  thermostat = value;
}

static DelayQueue<DelayedRunnable> dqueue = new DelayQueue<DelayedRunnable>();

ScheduledThreadPoolExecutor scheduler =
  new ScheduledThreadPoolExecutor(10);

public void schedule(DelayedRunnable event) {
 dqueue.add(event);
}

public void
repeat(DelayedRunnable event, int period, int repeat) {
	schedule(event);
	for (int i=1;i<repeat;i++) {
	schedule(event);
}
	

}
class LightOn extends DelayedRunnable {
   public LightOn(int milliseconds) {
	  delta=milliseconds;
	  trigger = System.nanoTime() +NANOSECONDS.convert(delta, MILLISECONDS);
  } 	
	public void run() {
     System.out.println("Turning on lights");
    light = true;
}
}
class LightOff extends DelayedRunnable{
	  public LightOff(int milliseconds) {
		  delta=milliseconds;
		  trigger = System.nanoTime() +NANOSECONDS.convert(delta, MILLISECONDS);
	  } 	

  public void run() {
    // Put hardware control code here to
    // physically turn off the light.
    System.out.println("Turning off lights");
    light = false;
} }
class WaterOn extends DelayedRunnable{
	  public WaterOn(int milliseconds) {
		  delta=milliseconds;
		  trigger = System.nanoTime() +NANOSECONDS.convert(delta, MILLISECONDS);
	  } 	

  public void run() {
    // Put hardware control code here.
    System.out.println("Turning greenhouse water on");
    water = true;
} }
class WaterOff extends DelayedRunnable{
	  public WaterOff(int milliseconds) {
		  delta=milliseconds;
		  trigger = System.nanoTime() +NANOSECONDS.convert(delta, MILLISECONDS);
	  } 	

  public void run() {
    // Put hardware control code here.
    System.out.println("Turning greenhouse water off");
    water = false;
} }
class ThermostatNight  extends DelayedRunnable{
	  public ThermostatNight(int milliseconds) {
		  delta=milliseconds;
		  trigger = System.nanoTime() +NANOSECONDS.convert(delta, MILLISECONDS);
	  } 	

  public void run() {
    // Put hardware control code here.
    System.out.println("Thermostat to night setting");
    setThermostat("Night");
} }
class ThermostatDay extends DelayedRunnable{
	  public ThermostatDay(int milliseconds) {
		  delta=milliseconds;
		  trigger = System.nanoTime() +NANOSECONDS.convert(delta, MILLISECONDS);
	  } 	

  public void run() {
    // Put hardware control code here.
    System.out.println("Thermostat to day setting");
    setThermostat("Day");
} }

class Bell  extends DelayedRunnable{
	  public Bell(int milliseconds) {
		  delta=milliseconds;
		  trigger = System.nanoTime() +NANOSECONDS.convert(delta, MILLISECONDS);
	  } 	

	public void run() { System.out.println("Bing!"); }
}
class Terminate extends DelayedRunnable{
	  public Terminate(int milliseconds) {
		  delta=milliseconds;
		  trigger = System.nanoTime() +NANOSECONDS.convert(delta, MILLISECONDS);
	  } 	

  public void run() {
    System.out.println("Terminating");
    dqueue.clear();
    
//    scheduler.shutdownNow();
    // Must start a separate task to do this job,
    // since the scheduler has been shut down:
    new Thread() {
      public void run() {
        for(DataPoint d : data)
          System.out.println(d);
      }
}.start(); }
}
// New feature: data collection
static class DataPoint {
  final Calendar time;
  final float temperature;
  final float humidity;
  public DataPoint(Calendar d, float temp, float hum) {
    time = d;
    temperature = temp;
    humidity = hum;
  }
  public String toString() {
    return time.getTime() +
      String.format(
        " temperature: %1$.1f humidity: %2$.2f",
        temperature, humidity);
  }
}
private Calendar lastTime = Calendar.getInstance();
{ // Adjust date to the half hour
  lastTime.set(Calendar.MINUTE, 30);
  lastTime.set(Calendar.SECOND, 00);
}
private float lastTemp = 65.0f;
private int tempDirection = +1;
private float lastHumidity = 50.0f;
private int humidityDirection = +1;
private Random rand = new Random(47);
List<DataPoint> data = Collections.synchronizedList(
  new ArrayList<DataPoint>());
class CollectData extends DelayedRunnable{
	 public CollectData(int milliseconds) {
		  delta=milliseconds;
		  trigger = System.nanoTime() +NANOSECONDS.convert(delta, MILLISECONDS);
	  } 	

  public void run() {
    System.out.println("Collecting data");
    synchronized(GreenhouseScheduler.this) {
      // Pretend the interval is longer than it is:
      lastTime.set(Calendar.MINUTE,
        lastTime.get(Calendar.MINUTE) + 30);
      // One in 5 chances of reversing the direction:
      if(rand.nextInt(5) == 4)
        tempDirection = -tempDirection;
      // Store previous value:
      lastTemp = lastTemp +
        tempDirection * (1.0f + rand.nextFloat());
      if(rand.nextInt(5) == 4)
        humidityDirection = -humidityDirection;
      lastHumidity = lastHumidity +
humidityDirection * rand.nextFloat();
        // Calendar must be cloned, otherwise all
        // DataPoints hold references to the same lastTime.
        // For a basic object like Calendar, clone() is OK.
        data.add(new DataPoint((Calendar)lastTime.clone(),
          lastTemp, lastHumidity));
      }
} }
  public static void main(String[] args) {
    GreenhouseScheduler gh = new GreenhouseScheduler();
    gh.schedule(gh.new Terminate(5000));
    // Former "Restart" class not necessary:
  
    for (int i=0;i<10;i++) {
    	 gh.schedule(gh.new ThermostatNight(2000*i));
    	    gh.schedule(gh.new LightOn(200*i));
    	    gh.schedule(gh.new LightOff(400*i));
    	    gh.schedule(gh.new WaterOn(600*i));
    	    gh.schedule(gh.new WaterOff(800*i));
    	    gh.schedule(gh.new ThermostatDay(1400*i));
    	    gh.schedule(gh.new CollectData(500+500*i));
    	
    	
    }
    
    /*gh.repeat(gh.new Bell(0),1000,10);
    gh.repeat(gh.new ThermostatNight(0),2000,10);
    gh.repeat(gh.new LightOn(0), 200,10);
    gh.repeat(gh.new LightOff(0), 400,10);
    gh.repeat(gh.new WaterOn(0), 600,10);
    gh.repeat(gh.new WaterOff(0), 800,10);
    gh.repeat(gh.new ThermostatDay(0), 1400,10);
    gh.repeat(gh.new CollectData(500), 500,10);
*/
    new Thread(){
    	public void run() {
    		while(true) 
    			try {
    			dqueue.take().run(); 
    			} catch (Exception e) {}
    	
    	}
    	
    
    }.run();
    try {
    TimeUnit.SECONDS.wait();
    } catch (Exception e) {}
    System.exit(0);
    
  }
  

  
}
