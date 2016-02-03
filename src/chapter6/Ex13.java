package chapter6;

class Base 

{
void doh(int i) {System.out.println("Doh int");}	
void doh(double d) {System.out.println("Doh double");}	
void doh(char c) {System.out.println("Doh char");}	
	
	
}

class Child extends Base {

	void doh(String s) {System.out.println("Doh string");}	
	
}





public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Child ch = new Child();
		
		ch.doh('A');
		ch.doh("A");
		ch.doh(1);
		ch.doh(1.1);
		
	}

}
