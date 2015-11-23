package chapter4;

class Finito {
	
	protected void finalize() {
	
		System.out.println("Finished");
		
		
	}
	
	
}

public class Ex10_11 {

	
	public static void main(String[] args) {
		
	Finito fin=new Finito();
	fin=null;
	System.gc();
		
		
		
	}
	
}
