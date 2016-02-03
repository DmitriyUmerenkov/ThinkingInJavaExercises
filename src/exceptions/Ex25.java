package exceptions;

class Event extends Exception {}
class Annoyance extends Event {}
class Sneeze extends Annoyance{}

class A {
	void a() throws Event {throw new Event();}
}

class B extends A {
	void a() throws Annoyance {throw new Annoyance();}
}

class C extends B {
	void a() throws Sneeze {throw new Sneeze();}
}


public class Ex25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		C aC = new C();
		
		try {
			((A)aC).a();
		}
		catch (Event e) {
			
		}
	}

}
