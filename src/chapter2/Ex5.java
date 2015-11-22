package chapter2;


class Dog {
	String name;
	String says;
	
	
}


public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Dog Dog1 =new Dog();
Dog Dog2 = new Dog();
		Dog1.name="spot";
		Dog1.says="Ruff!";

		Dog2.name="scruffy";
		Dog2.says="Wurf!";

		System.out.println(Dog1.name +" says " + Dog1.says);
		System.out.println(Dog2.name +" says " + Dog2.says);
		
		
		
	}

}
