package chapter9;

class Base5 {
	
	Base5(int i) {System.out.print("Creating Base5 i="+i);}
	Base5 getBase5(int i) {return new Base5(i);} 
}

class Second {
	
	Base5 GetBase5(int i)
	{
		
		return new Base5(i){};
		
	}
	
	
	
}



	public class Ex15 {
	 public static void main(String[] args) {
		 System.out.println(new Base5(1));
		 System.out.println(new Second().GetBase5(1));

		 
	 }
	}
