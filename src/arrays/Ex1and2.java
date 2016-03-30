package arrays;

import java.util.Arrays;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;
    public String toString() { return "Sphere " + id; }
  }


public class Ex1and2 {

	static void collide(BerylliumSphere[] balls) {
		
	}
	static BerylliumSphere[] getBalls(int size) {
		BerylliumSphere[] result= new BerylliumSphere[size];
		for (int i=0;i<size;i++) 
			result[i]=new BerylliumSphere();
		return result;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		collide (new BerylliumSphere[] {new BerylliumSphere(),new BerylliumSphere(),});
		//collide (new BerylliumSphere[] {new BerylliumSphere(),new BerylliumSphere(),});
		System.out.println(Arrays.toString(getBalls(5)));
		
		
	}

}
