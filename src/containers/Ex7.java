package containers;

import util.Countries;
import java.util.*;
public class Ex7 {

	
	public static void main (String[] Args) {
		List<String> aList1=new ArrayList<String>(Countries.names(10));
		List<String> aList2=new LinkedList<String>(Countries.names(10));
		
		Iterator<String>it1 = aList1.iterator();
		Iterator<String>it2 = aList2.iterator();
		
		while (it1.hasNext()) System.out.print(it1.next() + " ");
		System.out.println("");
		while (it2.hasNext()) System.out.print(it2.next() + " ");
		System.out.println("");
		
		ListIterator<String> lit1 = aList1.listIterator();
		ListIterator<String> lit2 = aList2.listIterator();
		
		while (lit1.hasNext() && lit2.hasNext()) {
			lit2.next();
			lit2.add(lit1.next());

		}
	
		System.out.println(aList1);
		System.out.println(aList2);
		
		aList1=new ArrayList<String>(Countries.names(10));
		aList2=new LinkedList<String>(Countries.names(10));

		lit1 = aList1.listIterator(aList1.size());
		lit2 = aList2.listIterator();

		while (lit1.hasPrevious() && lit2.hasNext()) {
			lit2.next();
			lit2.add(lit1.previous());
	
		}
		System.out.println(aList1);
		System.out.println(aList2);

	}
	
	
	
	
}
