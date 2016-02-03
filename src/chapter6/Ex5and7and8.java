package chapter6;

class A {
	A(int i) {System.out.println("Creating A " + i);}
	
	
}

class B {
	
	B(int i) {System.out.println("Creating B "+ i);}

	
}


class C extends A {
C() {super(1);}
	C(int i) {

		super(i);
		System.out.println("Creating C "+ i);
		b = new B(12);
				
	}
	
	B b;
	
	
}



public class Ex5and7and8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		C c = new C(11);
		
	}

}
