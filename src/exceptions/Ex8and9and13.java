package exceptions;

import java.util.Random;

public class Ex8and9and13 {

	static void throwMyException(int i) throws MyException, Exception1, Exception2 {
		switch(i) {
		case 1: throw new Exception1();
		case 2: throw new Exception2();
		default: throw new MyException();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		try {
			throwMyException(r.nextInt(3));
		}
		catch (Exception e) {
			System.out.println("Exception + "+e.getClass().getName());
		}
		finally {
			System.out.println("Finally.");
		}
	}

}
