package generics;

import java.util.*;
public class RandomList<T> {
private ArrayList<T> storage = new ArrayList<T>();
private Random rand = new Random(47);
public void add(T item) { storage.add(item); }
public T select() {
return storage.get(rand.nextInt(storage.size()));
}
public static void main(String[] args) {
RandomList<String> rs = new RandomList<String>();
for(String s: ("The quick brown fox jumped over " +
"the lazy brown dog").split(" "))
rs.add(s);
for(int i = 0; i < 11; i++)
System.out.print(rs.select() + " ");


RandomList<Integer> is = new RandomList<Integer>();
for(Integer i: new int[]{0,1,2,3,4,5,6,7,8,9,10})
is.add(i);
for(int i = 0; i < 11; i++)
System.out.print(is.select() + " ");

RandomList<Double> fs = new RandomList<Double>();
for(Double f: new double[]{0,1,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10})
fs.add(f);
for(int i = 0; i < 11; i++)
System.out.print(is.select() + " ");







}
}
