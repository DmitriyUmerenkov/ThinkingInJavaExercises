package generics;

import java.util.*;
import util.*;

class SmallFish {
  private static long counter = 1;
  private final long id = counter++;
  private SmallFish() {}
  public String toString() { return "SmallFish " + id; }
  // A method to produce Generator objects:
  public static Generator<SmallFish> generator() {
    return new Generator<SmallFish>() {
      public SmallFish next() { return new SmallFish(); }
}; }
}
class BigFish {
  private static long counter = 1;
  private final long id = counter++;
  private BigFish() {}
  public String toString() { return "BigFish " + id; }
  // A single Generator object:
  public static Generator<BigFish> generator =
    new Generator<BigFish>() {
      public BigFish next() { return new BigFish(); }
}; }



public class Ocean {

	public static void feed(BigFish t, SmallFish c) {
        System.out.println(t + " eats " + c);
      }
      public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<SmallFish> line = new LinkedList<SmallFish>();
        Generators.fill(line, SmallFish.generator(), 15);
        List<BigFish> tellers = new ArrayList<BigFish>();
        Generators.fill(tellers, BigFish.generator, 4);
        
		for(SmallFish c : line)
          feed(tellers.get(rand.nextInt(tellers.size())), c);
      }
	
	
}
