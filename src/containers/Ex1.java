package containers;
import java.util.*;
import util.*;

public class Ex1 {

	public static void main(String[] args) {
		
		List<String> aList1 = new ArrayList<String>(Countries.names(10));
		
		List<String> aList2 = new LinkedList<String>(Countries.names(15));
		
		System.out.println(aList1);
		System.out.println(aList2);

	Collections.sort(aList1);
	Collections.sort(aList2);

	System.out.println(aList1);
	System.out.println(aList2);

	Collections.shuffle(aList1);
	Collections.shuffle(aList2);

	System.out.println(aList1);
	System.out.println(aList2);

	Collections.shuffle(aList1);
	Collections.shuffle(aList2);

	System.out.println(aList1);
	System.out.println(aList2);
	}
	
	
}
