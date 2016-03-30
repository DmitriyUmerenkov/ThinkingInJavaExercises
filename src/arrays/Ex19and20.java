package arrays;

import java.util.*;

class WithInt implements Comparable<WithInt>{
	private int value;
	WithInt(int value) {this.value=value;}
	
	@Override
	public boolean equals(Object compared) {
		
		if (((WithInt)compared).value==this.value) return true;
		else return false;
	}

	@Override
	public int compareTo(WithInt o) {
		// TODO Auto-generated method stub
		return this.value<o.value?-1:(this.value==o.value?0:1);
	}
	
	public String toString() {return ""+value;}
	
	static class WithIntComparator implements Comparator<WithInt> {

		@Override
		public int compare(WithInt o1, WithInt o2) {
			// TODO Auto-generated method stub
			return o1.value<o2.value?1:(o1.value==o2.value?0:-1);

		}
		
	}
	
}


public class Ex19and20 {

	public static void main(String[] args) {
		WithInt[] first = new WithInt[5];
		WithInt[] second = new WithInt[5];
		int[][] firstInt = new int[5][5];
		int[][] secondInt = new int[5][5];

		for (int i=0;i<5;i++) {
			first[i]= new WithInt(5-i);
			second[i]= new WithInt(5-i);
			Arrays.fill(firstInt[i], i);
			Arrays.fill(secondInt[i], i);
		
		}
		
System.out.println(Arrays.equals(first, second));

System.out.println(Arrays.deepToString(firstInt));
System.out.println(Arrays.deepToString(secondInt));

System.out.println(Arrays.deepEquals(firstInt, secondInt));

System.out.println(Arrays.toString(first));

Arrays.sort(first);

System.out.println(Arrays.toString(first));

Arrays.sort(first, new WithInt.WithIntComparator());
		
System.out.println(Arrays.toString(first));

System.out.println(Arrays.binarySearch(first, first[2],new WithInt.WithIntComparator()));
	
		
		
	}

}
