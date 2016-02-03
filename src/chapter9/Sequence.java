package chapter9;
import java.util.*;

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


public class Sequence {
 private ArrayList items;
 private int next = 0;
 
 public Sequence(int size) { items = new ArrayList(); }
 public void add(Object x) {
 items.add(x);
 }
 private class SequenceSelector implements Selector {
 private int i = 0;
 public boolean end() { return i == items.size(); }
 public Object current() { return items.get(i); }
 public void next() { if(i < items.size()) i++; }
 public Sequence parent() {return Sequence.this;}
 }
 
 private class ReverseSelector implements Selector {
	 private int i = items.size()-1;
	 public boolean end() { return i == -1; }
	 public Object current() { return items.get(i); }
	 public void next() { if(i >= 0) i--; }
	 public Sequence parent() {return Sequence.this;}
	 }
 
 
 public Selector selector() {
	 return new SequenceSelector();
 }
 public Selector reverseselector() {
	 return new ReverseSelector();
 }
 
 public static void main(String[] args) {
 Sequence sequence = new Sequence(10);
 
 for(int i = 0; i < 20; i++)
	 sequence.add(new StringContainer("String no "+i));
	 
	 
	 // sequence.add(Integer.toString(i));
 Selector selector = sequence.selector();
 Sequence sequence2= (Sequence)selector.parent();
 //Sequence.SequenceSelector selector2=(Sequence.SequenceSelector)selector;
 
 
 while(!selector.end()) {
 System.out.print(selector.current() + " ");
 selector.next();
 }
 }
}