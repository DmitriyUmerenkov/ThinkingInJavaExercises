package containers;

import java.util.*;
import util.RandomGenerator;

public class Ex9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet<String> aSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		
		
		RandomGenerator.String gen = new RandomGenerator.String();
		for (int i=0;i<10;i++) 
			aSet.add(gen.next());
		
		System.out.println(aSet);
		
		
	}

}
