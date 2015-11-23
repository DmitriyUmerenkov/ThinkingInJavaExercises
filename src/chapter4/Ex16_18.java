package chapter4;

class ConstructedString {
	ConstructedString (String s) {
		System.out.println(s);	
	}
	
	
	
}


public class Ex16_18 {

	public static void main(String[] args) {
		String[] st1 = {"One", "Two", "Three",};
		
		for (String s: st1)
		System.out.println(s);
		
		ConstructedString[] cs = new ConstructedString[3];
		
		for (ConstructedString it: cs)
		it = new ConstructedString("Build");
		
		
		
	}

}
