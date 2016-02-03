package chapter10;

import java.util.*
;

interface Selector {
 boolean end();
 Object current();
 void next();
 Object parent();
}

class StringContainer {
	String st;
	StringContainer(String st) {this.st=st;}
	public String toString() {return st;}
	
}


public class Sequence<T>{
 private ArrayList<T> items;
 //private int next = 0;
 
 public Sequence(int size) { items = new ArrayList<T>(); }
 public void add(T x) {
 items.add(x);
 }
  
 public Iterator<T> iterator() {
	 return items.iterator();
 } 
 
 public static void main(String[] args) {
 Sequence<StringContainer> sequence = new Sequence<StringContainer>(10);
 
 for(int i = 0; i < 20; i++)
	 sequence.add(new StringContainer("String no "+i));
	 
	 
	 // sequence.add(Integer.toString(i));
 Iterator<StringContainer> selector = sequence.iterator();
  
 
 while(selector.hasNext()) 
 System.out.print(selector.next() + " ");
 }
}