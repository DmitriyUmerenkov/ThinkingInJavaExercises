package strings;

class Holder {
	int i=10;
	long l = 20000;
	float f = 12.34f;
	double d = 123.456;
	
	public String toString() {
		return new String().format("The class Holder contais an int %d, a long %d a float %f and a double %f.", i,l,f,d);
		
	}
	
	
}


public class Ex6 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new Holder().toString());
		
	}

}
