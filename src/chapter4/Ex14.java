package chapter4;

class TestStatic {
	static String st1 ="First string";
	static String st2;
	static {
	st2="Second string";
	}
	static void print() {
		System.out.println(st1);
		System.out.println(st2);
	}
	
}


public class Ex14 {

	public static void main(String[] args) {
	TestStatic.print();
	}

}
