package chapter4;

class Tank {
	boolean hasWater;
	void fill() {hasWater=true;}
	void empty() {hasWater=false;}
protected void finalize() {if(hasWater) System.out.println("Error, tank full");} 	
	
	
	
}



public class Ex12 {

	public static void main(String[] args) {

		Tank t1=new Tank();
		Tank t2=new Tank();
		t1.fill();
		t2.fill();
		t1.empty();
		System.out.println("T1 Full " + t1.hasWater);
		System.out.println("T2 Full " + t2.hasWater);
		t1=null;
		t2=null;
		System.out.println("Shutting down");
		System.gc();
	}

}
