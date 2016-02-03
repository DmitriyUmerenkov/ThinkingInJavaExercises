package exceptions;



public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		
		throw new Exception("ping");
		}
		
		catch (Exception e) {
		
			System.out.println("Caught! " + e.getMessage());
		
		}
		finally {
			System.out.println("And finally!");
		
		}
	
		
		
		
		
	}

}
