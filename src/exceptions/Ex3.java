package exceptions;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ar = new int[2];
		
		try {
			ar[2]++;		
		
		}
		catch (Exception e) {
			System.out.println(e.getClass());
			throw new RuntimeException(e);
		}
		}

}
