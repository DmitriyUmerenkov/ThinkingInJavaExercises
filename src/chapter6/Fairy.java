package chapter6;

//Inheritance syntax & properties.
import static util.Print.print;
class Cleanser {
private String s = "Cleanser";
public void append(String a) { s += a; }
public void dilute() { append(" dilute()"); }
public void apply() { append(" apply()"); }
public void scrub() { append(" scrub()"); }
public String toString() { return s; }
public static void main(String[] args) {
Cleanser x = new Cleanser();
x.dilute(); x.apply(); x.scrub();
print(x);
}
}

class Detergent {
	
	private Cleanser cs = new Cleanser();
	
	public void append(String a) { cs.append(a); }
	public void dilute() { cs.dilute(); }
	public void apply() { cs.apply(); }
	public void scrub() { append(" Detergent.scrub()");cs.scrub(); }
	public String toString() { return cs.toString(); }
	
	
	
	
	
// Change a method:
// Add methods to the interface:
public void foam() { append(" foam()"); }
// Test the new class:
public static void main(String[] args) {
Detergent x = new Detergent();
x.dilute();
x.apply();
x.scrub();
x.foam();
print(x);
print("Testing base class:");
Cleanser.main(args);
}
} 


public class Fairy extends Detergent{

	public void scrub() {
		append(" Fairy.scrub()");
		super.scrub(); // Call base-class version
		}
		// Add methods to the interface:
		public void sterilize() { append(" sterilize()"); }
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Fairy bt = new Fairy();
bt.dilute();
bt.apply();
bt.scrub();
bt.foam();
bt.sterilize();
print(bt);

print("Testing base class Cleanser:");
Cleanser.main(args);

print("Testing base class Detergent:");
Detergent.main(args);
	
	
	
	}

}
