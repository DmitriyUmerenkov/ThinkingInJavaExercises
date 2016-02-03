package exceptions;

//class MyException extends Exception {}

class Father {
	Father() throws MyException { throw new MyException();} 
}

class Son extends Father {
	Son() throws MyException {
	/*	try{
			super();
					
		}
		catch (MyException e) {
			
		}
		*/	
	
	}
}



public class Ex21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
