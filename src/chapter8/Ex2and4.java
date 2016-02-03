package chapter8;

abstract class Abstraction{
	abstract void enjoy();
}

class Realism extends Abstraction {
	void enjoy (){System.out.println("Enjoying art");};
	
}


public class Ex2and4 {

	static void EnjoyAbstraction (Abstraction abs) {
		
		abs.enjoy();

	}
	public static void main(String[] args) {
		Realism real=new Realism();
			
//			abs.enjoy;
			EnjoyAbstraction(real);
		}
		
		
		
	}	

