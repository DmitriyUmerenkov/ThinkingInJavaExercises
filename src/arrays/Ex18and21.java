package arrays;
import java.util.Arrays;

import util.*;

public class Ex18and21 {

	public static void main(String[] args) {
		BerylliumSphere[] first = new BerylliumSphere[5];
		BerylliumSphere[] second = new BerylliumSphere[5];

		for (int i=0;i<5;i++)
			first[i]=new BerylliumSphere();
		
		System.arraycopy(first, 0, second, 0, 5);
		System.out.println(Arrays.toString(first));
		System.out.println(Arrays.toString(second));
		
		
		
	}

}
