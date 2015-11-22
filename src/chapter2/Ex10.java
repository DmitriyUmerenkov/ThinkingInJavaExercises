package chapter2;

public class Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i1=0xAAAAAAAA;
		int i2=0x55555555;
		
		System.out.println("i1 "+ Integer.toBinaryString(i1));
		System.out.println("i2 " + Integer.toBinaryString(i2));
		

		System.out.println("AND " + Integer.toBinaryString(i1&i2));
		System.out.println("OR " + Integer.toBinaryString(i1|i2));
		System.out.println("XOR " + Integer.toBinaryString(i1^i2));
		System.out.println("NOT1 " + Integer.toBinaryString(~i1));
		System.out.println("NOT2 " + Integer.toBinaryString(~i2));
		
	}

}
