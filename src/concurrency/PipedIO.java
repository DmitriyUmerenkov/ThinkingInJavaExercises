package concurrency;

import java.util.concurrent.*;

import java.io.*;
import java.util.*;
import static util.Print.*;
class Sender implements Runnable {
  private Random rand = new Random(47);
  private PipedWriter out = new PipedWriter();
  private BlockingQueue<Character> outq = new LinkedBlockingQueue<Character>();
  
  public BlockingQueue<Character> getBlockingQueue() {return outq;}
  
  public PipedWriter getPipedWriter() { return out; }
  public void run() {
    try {
      while(true)
        for(char c = 'A'; c<= 'z'; c++) {
        outq.put(c);
        	//  out.write(c);
          TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
        }
    }// catch(IOException e) {
    //  print(e + " Sender write exception");
   // }
  catch(InterruptedException e) {
      print(e + " Sender sleep interrupted");
    }
} }
class Receiver implements Runnable {
  private PipedReader in;
  private BlockingQueue<Character> inq;
  public Receiver(Sender sender) throws IOException {
    in = new PipedReader(sender.getPipedWriter());
    inq= sender.getBlockingQueue();
  }
  public void run() {
    try {
      while(true) {
        // Blocks until characters are there:
        printnb("Read: " + inq.take() + ", ");
      }
    } catch(InterruptedException e) {
      print(e + " Receiver Interrupted exception");
} }
}
public class PipedIO {
  public static void main(String[] args) throws Exception {
    Sender sender = new Sender();
    Receiver receiver = new Receiver(sender);
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(sender);
    exec.execute(receiver);
    TimeUnit.SECONDS.sleep(4);
    exec.shutdownNow();
  }
}
