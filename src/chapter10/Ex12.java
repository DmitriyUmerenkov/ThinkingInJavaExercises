package chapter10;
import java.util.*;

public class Ex12 {

	public static void main(String[] Args) {
		
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(10,11,12,13,14,15,16,17));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(20,21,22,23,24,25,26,27));		
		ListIterator<Integer> lit2 =list2.listIterator();
		ListIterator<Integer> lit1=list1.listIterator(list1.size());
		
		System.out.println(list1);
		System.out.println(list2);

		
		while (lit1.hasPrevious()) lit2.add(lit1.previous());
		
		System.out.println(list1);
		System.out.println(list2);
		
	}
	
}
