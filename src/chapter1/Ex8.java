package chapter1;

class FamilyMember {
	static String House;
	String name;
}


public class Ex8 {

	public static void main(String[] args) {
		FamilyMember Mom = new FamilyMember();
		FamilyMember Dad = new FamilyMember();
Mom.name="Sara";
Dad.name="John";

//Mom.House="aHouse";
FamilyMember.House="aHouse";

//System.out.println("Mom " + Mom.name + " house " + Mom.House );
//System.out.println("Dad " + Dad.name + " house " + Dad.House );

//Dad.House = "anotherHouse";
System.out.println("Moving Dad" );

//System.out.println("Mom " + Mom.name + " house " + Mom.House );
//System.out.println("Dad " + Dad.name + " house " + Dad.House );

	}

}
