package chapter10;

import java.util.*;
import static util.Print.*;

public class ListFeaturesS {
 public static void main(String[] args) {
 Random rand = new Random(47);
 List<String> letters = new ArrayList<String> (Arrays.asList("alpha","beta","gamma","delta","epsilon","theta"));
 print("1: " + letters);
 String s = new String("omicron");
 letters.add(s); // Automatically resizes
 print("2: " + letters);
 print("3: " + letters.contains(s));
 letters.remove(s); // Remove by object
 String p = letters.get(2);
 print("4: " + p + " " + letters.indexOf(p));
 String cymric = new String("gamma");
 print("5: " + letters.indexOf(cymric));
 print("6: " + letters.remove(cymric));
 // Must be the exact object:
 print("7: " + letters.remove(p));
 print("8: " + letters);
 letters.add(3, new String ("psi")); // Insert at an index
 print("9: " + letters);
 List<String> sub = letters.subList(1, 4);
 print("subList: " + sub);
 print("10: " + letters.containsAll(sub));
 Collections.sort(sub); // In-place sort
 print("sorted subList: " + sub);
 // Order is not important in containsAll():
 print("11: " + letters.containsAll(sub));
 Collections.shuffle(sub, rand); // Mix it up
 print("shuffled subList: " + sub);
 print("12: " + letters.containsAll(sub));
 List<String> copy = new ArrayList<String>(letters);
 sub = Arrays.asList(letters.get(1), letters.get(4));
 print("sub: " + sub);
 copy.retainAll(sub);
 print("13: " + copy);
 copy = new ArrayList<String>(letters); // Get a fresh copy
 copy.remove(2); // Remove by index
 print("14: " + copy);
 copy.removeAll(sub); // Only removes exact objects
 print("15: " + copy);
 copy.set(1, new String("phi")); // Replace an element
 print("16: " + copy);
 copy.addAll(2, sub); // Insert a list in the middle
 print("17: " + copy);
 print("18: " + letters.isEmpty());
 letters.clear(); // Remove all elements
 print("19: " + letters);
 print("20: " + letters.isEmpty());
 letters.addAll(new ArrayList<String>(Arrays.asList("alpha", "beta", "gamma", "delta")));
 print("21: " + letters);
 Object[] o = letters.toArray();
 print("22: " + o[3]);
 }
}