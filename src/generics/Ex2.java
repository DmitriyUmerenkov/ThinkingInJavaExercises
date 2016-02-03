package generics;

class ThreeHolder<T> {
	private T first;
	private T second;
	private T third;
	T getFirst() {return first;}
	T getSecond() {return second;}
	T getThird() {return third;}

	void setFirst(T value) {first=value;}
	void setSecond(T value) {second=value;}
	void setThird(T value) {third=value;}

	ThreeHolder(T first, T second, T third) 
	{
		this.first=first;
		this.second=second;
		this.third=third;
		
	}
}


public class Ex2 {

	public static void main (String[] Args) {
	
		ThreeHolder<String> StringHolder= new ThreeHolder<String>("aa","bb","cc");
		ThreeHolder<Integer> IntegerHolder= new ThreeHolder<Integer>(11,12,13);
			
		
	}
	
	
	
}
