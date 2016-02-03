package chapter7;
import static util.Print.*;

class Base {
	void method2() {print("Base Calling method2");}
	void method1() {print("Base Calling method1 and redirecting"); method2();}
	
	
}

class Derived extends Base
{
	
	void method2() {print("Derived Calling method2");}
	
}


public class Ex10 {

	public static void main(String[] args) {

		Base b = new Derived();
		
		b.method1();
		
		
	}
	
	
}
