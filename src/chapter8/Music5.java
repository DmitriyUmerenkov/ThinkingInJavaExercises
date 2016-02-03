package chapter8;

import static util.Print.*;
import java.util.*;
import chapter7.Note;


interface Playable {
	public void play(Note n);
	
}


abstract class Instrument implements Playable{
	 // Compile-time constant:
	 int VALUE = 5; // static & final
	 // Cannot have method definitions:
	 public void play(Note n) {
	 print(this + ".play() " + n);
	 }
	 public void adjust() { print(this + ".adjust()"); }
	}
	class Wind extends Instrument implements Playable {
	 public String toString() { return "Wind"; }

	}
	class Percussion extends Instrument implements Playable {
	 public String toString() { return "Percussion"; }
	}
	class Stringed extends Instrument implements Playable {
	 public String toString() { return "Stringed"; }
	}
	class Brass extends Wind {
	 public String toString() { return "Brass"; }
	}
	class Woodwind extends Wind {
	 public String toString() { return "Woodwind"; }
	}
	public class Music5 {
	 // Doesn’t care about type, so new types
	 // added to the system still work right:
	 static void tune(Playable p) {
	 // ...
	 p.play(Note.MIDDLE_C);
	 }
	 static void tuneAll(Playable[] p) {
	 for(Playable i : p)
	 tune(i);
	 }
	 public static void main(String[] args) {
	 // Upcasting during addition to the array:
	 Instrument[] orchestra = {
	 new Wind(),
	 new Percussion(),
	 new Stringed(), 
	 new Brass(),
	 new Woodwind()
	 };
	 tuneAll(orchestra);
	 }
	} 