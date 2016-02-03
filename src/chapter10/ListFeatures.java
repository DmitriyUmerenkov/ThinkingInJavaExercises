package chapter10;

import java.util.*;

import static util.Print.*;
public class ListFeatures {
 public static void main(String[] args) {
 Random rand = new Random(47);
 List<Integer> ints = new ArrayList<Integer>(Arrays.asList(10, 11, 12, 13, 14, 15, 16));

 print("1: " + ints);
 Integer i = new Integer(9);
 ints.add(i); // Automatically resizes
 print("2: " + ints);
 print("3: " + ints.contains(i));
 ints.remove(i); // Remove by object
 Integer p = ints.get(2);
 print("4: " + p + " " + ints.indexOf(p));
 Integer cymric = new Integer(12);
 print("5: " + ints.indexOf(cymric));
 print("6: " + ints.remove(cymric));
 // Must be the exact object:
 print("7: " + ints.remove(p));
 print("8: " + ints);
 ints.add(3, new Integer(99)); // Insert at an index
 print("9: " + ints);
 List<Integer> sub = ints.subList(1, 4);
 print("subList: " + sub);
 print("10: " + ints.containsAll(sub));
 Collections.sort(sub); // In-place sort
 print("sorted subList: " + sub);
 // Order is not important in containsAll():
 print("11: " + ints.containsAll(sub));
 Collections.shuffle(sub, rand); // Mix it up
 print("shuffled subList: " + sub);
 print("12: " + ints.containsAll(sub));
 List<Integer> copy = new ArrayList<Integer>(ints);
 sub = Arrays.asList(ints.get(1), ints.get(4));
 print("sub: " + sub);
 copy.retainAll(sub);
 print("13: " + copy);
 copy = new ArrayList<Integer>(ints); // Get a fresh copy
 copy.remove(2); // Remove by index
 print("14: " + copy);
 copy.removeAll(sub); // Only removes exact objects
 print("15: " + copy);
 copy.set(1, new Integer(98)); // Replace an element
 print("16: " + copy);
 copy.addAll(2, sub); // Insert a list in the middle
 print("17: " + copy);
 print("18: " + ints.isEmpty());
 ints.clear(); // Remove all elements
 print("19: " + ints);
 print("20: " + ints.isEmpty());
 ints.addAll(new ArrayList<Integer>(Arrays.asList(21,21,22,23)));
 print("21: " + ints);
 Object[] o = ints.toArray();
 print("22: " + o[3]);
 }
}