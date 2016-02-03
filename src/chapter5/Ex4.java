package chapter5;

public class Ex4 {

	public static void main(String[] args) {
		AccessMod md = new AccessMod();

		
    	//	md.st1 ="a";
			md.st2 ="a";
			md.st3 ="a";
			md.st4 ="a";
					
			md.packageaccessMethod();
			md.protectedMethod();
			md.publicMethod();
		//	md.privateMethod();
	}

}
