package chapter2;

class AliasExample {
	float f;
}



public class Ex2 {

	public static void main(String[] args) {

		AliasExample Ex1=new AliasExample();
		AliasExample Ex2=Ex1;
		Ex1.f=3.33f;
		
		
		System.out.println("Ex1.f="+Ex1.f);
		System.out.println("Ex2.f="+Ex2.f);
		
		System.out.println("Setting Ex1.f");
		Ex1.f=33.333f;
		System.out.println("Ex1.f="+Ex1.f);
		System.out.println("Ex2.f="+Ex2.f);

		
	}
	
	

}
