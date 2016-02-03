package chapter9;

public class Parcel7 {
	
	
	
	 public Contents contents() {
	 return new Contents() { // Insert a class definition
	 private int i = 22;
	 public int value() { i++ ;return i; }
	 }; // Semicolon required in this case
	 }
	 public static void main(String[] args) {
	 Parcel7 p = new Parcel7();
	 Contents c = p.contents();
	  
	 
	 System.out.println(c.value());
	 }
	} 
