package chapter7;

import static util.Print.*;
import java.util.*;

class Instrument {
 void play(Note n) { print("Instrument.play() " + n); }
 String what() { return this.toString(); }
 void adjust() { print("Adjusting Instrument"); }
}
class Wind extends Instrument {
 void play(Note n) { print("Wind.play() " + n); }
 String what() { return "Wind"; }
 void adjust() { print("Adjusting Wind"); }
 void clearSpitValve() { print("ClearingSpittingValve"); }
}
class Percussion extends Instrument {
 void play(Note n) { print("Percussion.play() " + n); }
 String what() { return "Percussion"; }
 void adjust() { print("Adjusting Percussion"); }
}
class Stringed extends Instrument { 
	void play(Note n) { print("Stringed.play() " + n); }
	 String what() { return "Stringed"; }
	 void adjust() { print("Adjusting Stringed"); }
	}

class Brass extends Wind {
	void play(Note n) { print("Brass.play() " + n); }
	 void adjust() { print("Adjusting Brass"); }
	}
class Woodwind extends Wind {
	 void play(Note n) { print("Woodwind.play() " + n); }
	 String what() { return "Woodwind"; }
	}
class Reed extends Wind {
	 void play(Note n) { print("Reed.play() " + n); }
	 String what() { return "Reed"; }
		}
	
	
	public class Music3 {
	 // Doesn’t care about type, so new types
	 // added to the system still work right:
	 public static void tune(Instrument i) {
	 // ...
	 i.play(Note.MIDDLE_C);
	 }
	 public static void tuneAll(Instrument[] e) {
	 for(Instrument i : e)
	 {	 
	  if (i instanceof Wind)
		 ((Wind) i).clearSpitValve();
		 tune(i);
	 }
	 }
	 public static void whatAll(Instrument[] e) {
		 for(Instrument i : e)
		 System.out.println(i.what());
		 }
	 
	 
	 public static void main(String[] args) {
	 // Upcasting during addition to the array:
	 Instrument[] orchestra = new Instrument[10];
	 Random r = new Random();

	 for (int i =0;i<10;i++)
	 switch(r.nextInt(6))
	 {
	 default:
	 case 0: orchestra[i]=new Wind(); break;
	 case 1: orchestra[i]=new Percussion(); break;
	 case 2: orchestra[i]=new Stringed(); break;
	 case 3: orchestra[i]=new Brass(); break;
	 case 4: orchestra[i]=new Woodwind(); break;
	 case 5: orchestra[i]=new Reed();
	 }
	 	 
	 tuneAll(orchestra);
	 whatAll(orchestra);
	 }
	}