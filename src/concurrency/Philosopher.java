package concurrency;

import java.util.concurrent.*;
import java.util.*;
import static util.Print.*;
public class Philosopher implements Runnable {
  private Chopstick left;
  private Chopstick right;
  private BlockingQueue<Chopstick> bin;
  private final int id;
  private final int ponderFactor;
  private Random rand = new Random(47);
  private void pause() throws InterruptedException {
    if(ponderFactor == 0) return;
    TimeUnit.MILLISECONDS.sleep(
      rand.nextInt(ponderFactor * 250));
  }
  public Philosopher(int ident, int ponder, BlockingQueue<Chopstick> bin) {
id = ident;
    ponderFactor = ponder;
    this.bin=bin;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        print(this + " " + "thinking");
        pause();
        // Philosopher becomes hungry
        print(this + " " + "grabbing right");
        right=bin.take();
        print(this + " " + "grabbing left");
        left=bin.take();
        print(this + " " + "eating");
        pause();
        print("Putting chopsticks back");
        bin.add(right);
        bin.add(left);
      }
    } catch(InterruptedException e) {
      print(this + " " + "exiting via interrupt");
    }
}
  public String toString() { return "Philosopher " + id; }
}
