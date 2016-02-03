package exceptions;

public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {0 ,1, 2, 3, 4}; 
		boolean Done=false;
		int index=10;
		while (!Done)
		{
			try { ar[--index]++;
				Done=true;
				
			}
			catch (Exception e) {
				System.out.println(e.getClass()+" index="+index);
				
			}
			
			
			
		}
		
	}

}
