package exceptions;
import java.util.*;


class HazardousWaste {
	static int counter=0;
	private int id=counter++;
	
	HazardousWaste() {System.out.println("Waste lot #"+id+" created");}
	public void dispose() {System.out.println("Waste lot #"+id+" destroyed");}
}


class FailingConstructor {
	static Random r = new Random();
	HazardousWaste waste1;
	HazardousWaste waste2;
	FailingConstructor() throws MyException {
		waste1=new HazardousWaste();
try {
		if (r.nextBoolean()) throw new MyException();
}
catch (MyException e) {
	System.out.println("Aborting creation");
	waste1.dispose();
	throw e;
}
		waste2=new HazardousWaste();
	}	
		void dispose() {waste1.dispose(); waste2.dispose();}
	
}


public class Ex22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FailingConstructor fc;
		try {
			fc = new FailingConstructor(); 
			System.out.println("Constructor succesfull");
			fc.dispose();
		}
		catch (MyException e)
		{
			System.out.println("Constructor failed, exception caught");

		}
		
		
		
		
	}

}
