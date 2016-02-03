package chapter8;

	abstract class Base {
		abstract void print();
				Base() {print();}
	}
	
	class Derived extends Base
	{
		int i=33;
		void print() {System.out.println("i="+i);}
		
	}


public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Derived d = new Derived();
		d.print();
		
		
	}

}
