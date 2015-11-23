package chapter4;

class StringWrapper {
	String st;
	String st2="At Definition";
	String st3;

StringWrapper()
{
	
st3="At Constructor";
}
	
}




public class Ex1_2 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringWrapper Wrap = new StringWrapper();
		System.out.println(Wrap.st);
		System.out.println(Wrap.st2);
		System.out.println(Wrap.st3);
		
		
	}

}
