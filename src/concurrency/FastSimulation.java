package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;
import java.util.*;
import static util.Print.*;
public class FastSimulation {
  static final int N_ELEMENTS = 100000;
  static final int N_GENES = 30;
  static final int N_EVOLVERS = 50;
  static final Integer[][] GRID =
    new Integer[N_ELEMENTS][N_GENES];
  static Random rand = new Random(47);
  static class Evolver implements Runnable {
	  static int iterations;
	  static Lock gridLock = new ReentrantLock();
	  static synchronized void increment() {iterations++;}    
	  public void run() {
      while(!Thread.interrupted()) {
        // Randomly select an element to work on:
        int element = rand.nextInt(N_ELEMENTS);
        for(int i = 0; i < N_GENES; i++) {
          int previous = element - 1;
          if(previous < 0) previous = N_ELEMENTS - 1;
          int next = element + 1;
          if(next >= N_ELEMENTS) next = 0;
          gridLock.lock(); try {
          int oldvalue = GRID[element][i];
          // Perform some kind of modeling calculation:
          int newvalue = oldvalue +
            GRID[previous][i] + GRID[next][i];
          newvalue /= 3; // Average the three values
          GRID[element][i]=newvalue;
           
} finally {gridLock.unlock();} increment();
          }
} }
  }
  public static void main(String[] args) throws Exception {
    ExecutorService exec = Executors.newCachedThreadPool();
    for(int i = 0; i < N_ELEMENTS; i++)
      for(int j = 0; j < N_GENES; j++)
        GRID[i][j] = rand.nextInt(1000);
    for(int i = 0; i < N_EVOLVERS; i++)
      exec.execute(new Evolver());
    TimeUnit.SECONDS.sleep(5);
    exec.shutdownNow();
    print ("Total increments" + Evolver.iterations);
  }
}
