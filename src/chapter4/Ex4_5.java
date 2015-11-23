package chapter4;

class Dog {
	void bark (int i)
	{
		System.out.println("Woof int");
		
	}
	void bark (double d)
	{
		System.out.println("Ruff double");
		
	}
	
	void bark (int i, double d)
	{
		System.out.println("Woof int, then Ruff double");
		
	}
	void bark (double d, int i)
	{
		System.out.println("Ruff double, then Woof int");
		
	}
		
	
	
}


public class Ex4_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Dog Barker = new Dog();
Barker.bark(1);
Barker.bark(1.0);
Barker.bark(1,1.0);
Barker.bark(1.0,1);


	}

}
