package chapter8;

import static util.Print.*;


interface Base11 {
	void base1method1 ();
	void base1method2 ();
}

interface Base2 {
	void base2method1 ();
	void base2method2 ();
}

interface Base3 {
	void base3method1 ();
	void base3method2 ();
}

interface DerivedInt extends Base11, Base2, Base3 {
	void derivedmethod();
	
}

abstract class BaseClass {}

class Child extends BaseClass implements DerivedInt {
	public void base1method1 (){print("base1method1");};
	public void base1method2 (){print("base1method2");};
	public void base2method1 (){print("base2method1");};
	public void base2method2 (){print("base2method2");};
	public void base3method1 (){print("base3method1");};
	public void base3method2 (){print("base3method2");};
	public void derivedmethod (){print("derivedmethod");};
}





public class Ex14 {

	static void a1(Base11 b) {b.base1method1();};
	static void a2(Base2 b) {b.base2method1();};
	static void a3(Base3 b) {b.base3method1();};
	static void a4(DerivedInt d) {d.derivedmethod();};
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Child c = new Child();
		a1(c);
		a2(c);
		a3(c);
		a4(c);
		
	}

}
