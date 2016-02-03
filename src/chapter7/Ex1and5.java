package chapter7;

class Cycle{
	
	void ride() {
		System.out.println("Riding, wheels = " + wheels());
	}
	int wheels() {return 0;}
	
}

class Unicycle extends Cycle {
	
	int wheels() {return 1;}
	void balance() {System.out.println("Balancing on wheels count " + wheels());}
	
}
class Bicycle extends Cycle {
	
	int wheels() {return 2;}
	void balance() {System.out.println("Balancing on wheels count " + wheels());}
}
class Tricycle extends Cycle {
	
	
	int wheels() {return 3;}
	
}


public class Ex1and5 {

	
	 public static void main(String[] args) {

	Unicycle U = new Unicycle();
	Bicycle B = new Bicycle();
	Tricycle T = new Tricycle();
	
	U.ride();
	B.ride();
	T.ride();
	
	Cycle[] ar = new Cycle[3];

	ar[0]=U;
	ar[1]=B;
	ar[2]=T;
	
	((Unicycle)ar[0]).balance();
	((Bicycle)ar[1]).balance();
	((Bicycle)ar[2]).balance();
	
	
	
	 }	
 	
	
}
