package exceptions;
import static util.Print.*;

 class Switch {
	 private boolean state = false;
	 public boolean read() { return state; }
	 public void on() { state = true; print(this); }
	 public void off() { state = false; print(this); }
	 public String toString() { return state ? "on" : "off"; }
	} ///:~

 //: exceptions/OnOffException1.java
	class OnOffException1 extends Exception {} ///:~
	
	//: exceptions/OnOffException2.java
	class OnOffException2 extends Exception {} ///:~
	//: exceptions/OnOffSwitch.java
	// Why use finally?
	
	public class OnOffSwitch {
	 private static Switch sw = new Switch();
	 public static void f()
	 throws OnOffException1,OnOffException2 {}
	 public static void g() {throw new RuntimeException();
	 }
	 
	 
	 public static void main(String[] args) {
	 try {
	 sw.on();
	 // Code that can throw exceptions...
	 f();
	 g();
	 } catch(OnOffException1 e) {
	 System.out.println("OnOffException1");
	 } catch(OnOffException2 e) {
	 System.out.println("OnOffException2");
	 }
	 finally {
		 sw.off();		 
	 }
	 
	 
	 
	 }
	 
	 
	 
	} 