package arrays;
import java.util.*;


public class Ex22and23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(47);
		
		Integer[] ar = new Integer[25];
		for (int i=0;i<25;i++) ar[i]=rand.nextInt(1000);
		
		System.out.println(Arrays.toString(ar));
		System.out.println(Arrays.binarySearch(ar, 128));
		System.out.println(Arrays.binarySearch(ar, 555));

		Arrays.sort(ar, Collections.reverseOrder());
		System.out.println(Arrays.toString(ar));

		
	}

}
