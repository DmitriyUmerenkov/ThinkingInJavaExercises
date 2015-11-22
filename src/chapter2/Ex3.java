package chapter2;

class FloatWrap {
	float f;
}



public class Ex3 {

	private static void ChangeFL (FloatWrap w) {
		w.f=23.23f;
	}
	
	public static void main(String[] args) {
	FloatWrap wrap= new FloatWrap();
	wrap.f=11.11f;
	System.out.println(wrap.f);
	ChangeFL(wrap);
	System.out.println(wrap.f);

	}

}
