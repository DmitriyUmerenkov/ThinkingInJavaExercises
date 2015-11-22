package chapter1;

class Envelope {
	
	int storage(String s) {
		 return s.length() * 2;
		} 
	
	
}

public class Ex6 {

	public static void main(String[] args) {
		System.out.println(new Envelope().storage("Contents"));
		
	}

}
