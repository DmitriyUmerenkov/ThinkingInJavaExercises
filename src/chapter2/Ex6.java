package chapter2;

public class Ex6 {

	public static void main(String[] args) {
		Dog Dog1 =new Dog();
		Dog Dog2 = new Dog();
		Dog Dog3=Dog1;
				Dog1.name="spot";
				Dog1.says="Ruff!";
				

				Dog2.name="scruffy";
				Dog2.says="Wurf!";

				System.out.println(Dog1.name +" says " + Dog1.says);
				System.out.println(Dog2.name +" says " + Dog2.says);

				System.out.println("Dog3==Dog1 "  + (Dog3==Dog1));
				System.out.println("Dog3 equals Dog1 "  + (Dog3.equals(Dog1)));

				System.out.println("Dog3==Dog2 "  + (Dog3==Dog2));
				System.out.println("Dog3 equals Dog2 "  + (Dog3.equals(Dog2)));

				
	}

}
