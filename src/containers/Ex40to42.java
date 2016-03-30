package containers;

import java.util.*;
import util.*;


class TwoStrings implements Comparable<TwoStrings>{
	String first;
	String second;
	
	TwoStrings(String first, String second) {this.first=first; this.second=second;}

	@Override
	public int compareTo(TwoStrings o) {
		return first.compareToIgnoreCase(o.first);
	}	
	@Override
	public String toString() {return first+" "+ second;}
	
	@Override
	public int hashCode() {
		
		return first.hashCode()*17+second.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o!=null && first==((TwoStrings)o).first && second==((TwoStrings)o).second) return true;
		else return false;
	}
	
}

public class Ex40to42 {

	
	public static void main (String[] atgs) {
		
		int SIZE=20;
		
		TwoStrings[] stringArray= new TwoStrings[SIZE];
		List<TwoStrings> stringList= new ArrayList<TwoStrings>();
		
		ArrayList<String> first = new ArrayList<String>(CollectionData.list(new RandomGenerator.String(), SIZE));
		ArrayList<String> second = new ArrayList<String>(CollectionData.list(new RandomGenerator.String(), SIZE));

		for (int i=0;i<SIZE;i++) 
		{
			stringArray[i]=new TwoStrings(first.get(i),second.get(i));
			stringList.add(new TwoStrings(first.get(i),second.get(i)));
		}
	
		System.out.println(Arrays.asList(stringArray));
		System.out.println(stringList);
		
		Arrays.sort(stringArray);
		stringList.sort(null);		
		System.out.println(Arrays.asList(stringArray));
		System.out.println(stringList);
		
		
		Comparator<TwoStrings> comp = new Comparator<TwoStrings>(){

			@Override
			public int compare(TwoStrings o1, TwoStrings o2) {
				// TODO Auto-generated method stub
				return o1.second.compareToIgnoreCase(o2.second);
			}
		
		};
		
		Arrays.sort(stringArray, comp );		
		stringList.sort(comp);
		
		System.out.println(Arrays.asList(stringArray));
		System.out.println(stringList);
		
		System.out.println("Position of qjncLdZ: "+Arrays.binarySearch(stringArray, new TwoStrings("","qjncLdZ"), comp));
		System.out.println("Position of qjncLdZ: "+Collections.binarySearch(stringList, new TwoStrings("","qjncLdZ"),comp));

		
	}
	
}
