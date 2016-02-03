package chapter10;
import java.util.*;

public class Ex11 {

	public static void seeAll(Collection c) {
		Iterator it = c.iterator();
		while (it.hasNext()) System.out.println(it.next());
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> pets = new ArrayList<String>(Arrays.asList("alpha", "beta","gamma"));
		 LinkedList<String> petsLL = new LinkedList<String>(Arrays.asList("alpha", "beta","gamma"));
		 HashSet<String> petsHS = new HashSet<String>(Arrays.asList("alpha", "beta","gamma"));
		 TreeSet<String> petsTS = new TreeSet<String>(Arrays.asList("alpha", "beta","gamma"));
		
		 seeAll(pets);
		 seeAll(petsLL);
		 seeAll(petsHS);
		 seeAll(petsTS);
		 
	}

}
