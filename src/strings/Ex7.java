package strings;

public class Ex7 {

	static boolean checkProperSentence(String s) {
		
		return s.matches("[A-Z].*\\.");
	}
	
	public static void main (String[] Args) {
		
		System.out.println(checkProperSentence("A."));
		System.out.println(checkProperSentence("ASdf."));
		System.out.println(checkProperSentence("a misproper."));
		System.out.println(checkProperSentence("A proper."));

		
		
	}
	
}
