package chapter3;

public class Ex9 {

	
	static void Fibb(int count) {
		
		int[] FibbArray = new int[count];
		
		FibbArray[0]=FibbArray[1]=1;
		
		for (int i=2;i<count;i++)
		FibbArray[i]=FibbArray[i-1]+FibbArray[i-2];
		
		for (int i1: FibbArray)
		System.out.print(i1+ " ");
		System.out.println("");
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		Fibb(3);
		Fibb(10);

	}

}
