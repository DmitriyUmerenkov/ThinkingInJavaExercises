package typeinfo;

public class Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] CharArray= new char[3];
		
		System.out.println("Name="+CharArray.getClass().getName());
		for (Class c: CharArray.getClass().getClasses() )
		System.out.println("Has class="+c.getName());
		System.out.println("SuperclassName="+CharArray.getClass().getSuperclass().getName());
		
		
	}

}
