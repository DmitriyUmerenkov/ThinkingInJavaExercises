package exceptions;

public class Ex10and11 {

	static void g() throws Exception1 {
		System.out.println("Inside g()");
		throw new Exception1();
		
	}
	
	static void f() {
System.out.println("Inside f()");
		
		try {
			g();
		}
		 catch (Exception1 e) {
			 
			 throw new RuntimeException(e);
			 
		 }
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			f();
		}
		catch (RuntimeException e) {
			
			System.out.println("Catched Exception2, cauese "+ e.getCause());
			
		}
		
	}

}
