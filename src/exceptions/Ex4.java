package exceptions;

class MyException extends RuntimeException {
	String MyMessage;
	public MyException(){};
	public MyException(String msg) {super(msg);MyMessage=msg;}
	public void getMyMessage() {System.out.println(MyMessage);}

}

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			throw new MyException("New");

		
		
		
		
	}

}
