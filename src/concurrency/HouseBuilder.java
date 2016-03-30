package concurrency;

import java.util.concurrent.*;
import java.util.*;
import static util.Print.*;
class House {
  private final int id;
  private boolean
    steel = false, concreteForm = false, concreteFoundation = false, piping=false, concreteSlab=false, framing=false;
  public House(int idn)  { id = idn; }
  // Empty House object:
  public House()  { id = -1; }
  public synchronized int getId() { return id; }

  public synchronized void addpiping() { piping = true; }
  public synchronized void addconcreteSlab() { concreteSlab = true; }
  public synchronized void addframing() { framing = true; }

  public synchronized void addsteel() { steel = true; }
  public synchronized void addconcreteForm() {
    concreteForm = true;
  }
  public synchronized void addconcreteFoundation() { concreteFoundation = true; }
  public synchronized String toString() {
    return "House " + id + " [" + " steel: " + steel
      + " concreteForm: " + concreteForm
      + " concreteFoundation: " + concreteFoundation 
      + " piping: " + piping 
      + " concreteSlab: " + concreteSlab 
      + " framing: " + framing 
      + " ]";
} }

class HouseQueue extends LinkedBlockingQueue<House> {}

class FootingsDigger implements Runnable {
  private HouseQueue HouseQueue;
  private int counter = 0;
  public FootingsDigger(HouseQueue cq) { HouseQueue = cq; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        TimeUnit.MILLISECONDS.sleep(500);
        // Make houses:
        House c = new House(counter++);
        print("Footing created " + c);
        // Insert into queue
        HouseQueue.put(c);
      }
    } catch(InterruptedException e) {
      print("Interrupted: FootingsDigger");
    }
    print("FootingsDigger off");
  }
}
class BuildManager implements Runnable {
  private HouseQueue housesQueue, finishingQueue;
  private House House;
  private CyclicBarrier barrier = new CyclicBarrier(3);
  private CyclicBarrier barrierSt2 = new CyclicBarrier(2);
  private CyclicBarrier barrierSt3 = new CyclicBarrier(2);
  private CyclicBarrier barrierSt4 = new CyclicBarrier(2);
  private CyclicBarrier barrierSt5 = new CyclicBarrier(2);
  
  private ContractorPool ContractorPool;
 
  public BuildManager(HouseQueue cq, HouseQueue fq, ContractorPool rp){
    housesQueue = cq;
    finishingQueue = fq;
    ContractorPool = rp;
  }
  public House House() { return House; }
  public CyclicBarrier barrier() { return barrier; }
  public CyclicBarrier barrierSt2() { return barrierSt2; }
  public CyclicBarrier barrierSt3() { return barrierSt3; }
  public CyclicBarrier barrierSt4() { return barrierSt4; }
  public CyclicBarrier barrierSt5() { return barrierSt5; }

  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until houses is available:
        House = housesQueue.take();
        // Hire Contractors to perform work:
        ContractorPool.hire(steelContractor.class, this);
        ContractorPool.hire(concreteFormContractor.class, this);
        barrier.await();
        ContractorPool.hire(ConcreteFoundationContractor.class, this);
        barrierSt2.await(); // Until the Contractors finish
        // Put House into finishingQueue for further work
        ContractorPool.hire(pipingContractor.class, this);
        barrierSt3.await(); // Until the Contractors finish
        ContractorPool.hire(concreteSlabContractor.class, this);
        barrierSt4.await(); // Until the Contractors finish
        ContractorPool.hire(framingContractor.class, this);
        barrierSt5.await();
        
        
        finishingQueue.put(House);
      }
    } catch(InterruptedException e) {
      print("Exiting BuildManager via interrupt");
    } catch(BrokenBarrierException e) {
      // This one we want to know about
      throw new RuntimeException(e);
    }
    print("BuildManager off");
  }
}

class ReporterH implements Runnable {
  private HouseQueue HouseQueue;
  public ReporterH(HouseQueue cq) { HouseQueue = cq; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        print(HouseQueue.take());
      }
    } catch(InterruptedException e) {
      print("Exiting Reporter via interrupt");
}
    print("Reporter off");
  }
}
abstract class Contractor implements Runnable {
  private ContractorPool pool;
  private CyclicBarrier barrier;
  public Contractor(ContractorPool p, CyclicBarrier b) { pool = p; barrier=b;}
  protected BuildManager BuildManager;
  public Contractor assignBuildManager(BuildManager BuildManager) {
    this.BuildManager = BuildManager;
    return this;
  }
  private boolean engage = false;
  public synchronized void engage() {
    engage = true;
    notifyAll();
  }
  // The part of run() that’s different for each Contractor:
  abstract protected void performService();
  public void run() {
    try {
      powerDown(); // Wait until needed
      while(!Thread.interrupted()) {
        performService();
        this.barrier.await(); // Synchronize
        // We’re done with that job...
        powerDown();
      }
    } catch(InterruptedException e) {
      print("Exiting " + this + " via interrupt");
    } catch(BrokenBarrierException e) {
      // This one we want to know about
      throw new RuntimeException(e);
    }
    print(this + " off");
  }
  private synchronized void
  powerDown() throws InterruptedException {
    engage = false;
    BuildManager = null; // Disconnect from the BuildManager
    // Put ourselves back in the available pool:
    pool.release(this);
    while(engage == false)  // Power down
wait(); }
  public String toString() { return getClass().getName(); }
}
class steelContractor extends Contractor {
  public steelContractor(ContractorPool pool, CyclicBarrier b) { super(pool, b); }
  protected void performService() {
    print(this + " installing steel lining");
    BuildManager.House().addsteel();
  }
}
class concreteFormContractor extends Contractor {
  public concreteFormContractor(ContractorPool pool, CyclicBarrier b) { super(pool, b); }
  protected void performService() {
    print(this + " installing concrete forms");
    BuildManager.House().addconcreteForm();
  }
}
class ConcreteFoundationContractor extends Contractor {
  public ConcreteFoundationContractor(ContractorPool pool, CyclicBarrier b) { super(pool, b); }
  protected void performService() {
    print(this + " pouring concrete foundation");
    BuildManager.House().addconcreteFoundation();
  }
}
class pipingContractor extends Contractor {
	  public pipingContractor(ContractorPool pool, CyclicBarrier b) { super(pool, b); }
	  protected void performService() {
	    print(this + " installing plumbing");
	    BuildManager.House().addconcreteFoundation();
	  }
	}
class concreteSlabContractor extends Contractor {
	  public concreteSlabContractor(ContractorPool pool, CyclicBarrier b) { super(pool, b); }
	  protected void performService() {
	    print(this + " pouring concrete Slab");
	    BuildManager.House().addconcreteFoundation();
	  }
	}
class framingContractor extends Contractor {
	  public framingContractor(ContractorPool pool, CyclicBarrier b) { super(pool, b); }
	  protected void performService() {
	    print(this + " installing framing");
	    BuildManager.House().addconcreteFoundation();
	  }
	}




class ContractorPool {
  // Quietly prevents identical entries:
  private Set<Contractor> pool = new HashSet<Contractor>();
  public synchronized void add(Contractor r) {
    pool.add(r);
    notifyAll();
  }
  public synchronized void
  hire(Class<? extends Contractor> ContractorType, BuildManager d)
  throws InterruptedException {
    for(Contractor r : pool)
      if(r.getClass().equals(ContractorType)) {
pool.remove(r);
r.assignBuildManager(d);
        r.engage(); // Power it up to do the task
return; }
    wait(); // None available
    hire(ContractorType, d); // Try again, recursively
  }
  public synchronized void release(Contractor r) { add(r); }
}

public class HouseBuilder {
  public static void main(String[] args) throws Exception {
    HouseQueue housesQueue = new HouseQueue(),
             finishingQueue = new HouseQueue();
    ExecutorService exec = Executors.newCachedThreadPool();
    ContractorPool ContractorPool = new ContractorPool();
    BuildManager asm = new BuildManager(
    	      housesQueue, finishingQueue, ContractorPool);
    
    exec.execute(new steelContractor(ContractorPool,asm.barrier()));
    exec.execute(new concreteFormContractor(ContractorPool,asm.barrier()));
    exec.execute(new ConcreteFoundationContractor(ContractorPool,asm.barrierSt2()));
    exec.execute(new pipingContractor(ContractorPool,asm.barrierSt3()));
    exec.execute(new concreteSlabContractor(ContractorPool,asm.barrierSt4()));
    exec.execute(new framingContractor(ContractorPool,asm.barrierSt5()));  
    exec.execute(asm);
    exec.execute(new ReporterH(finishingQueue));
    // Start everything running by producing houses:
    exec.execute(new FootingsDigger(housesQueue));
    TimeUnit.SECONDS.sleep(7);
    exec.shutdownNow();
  }
}

