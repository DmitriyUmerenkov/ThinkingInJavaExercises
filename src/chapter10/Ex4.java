package chapter10;
import java.util.*;

class FamilyName {
	final static String[] names ={"Kirill", "Platon", "Galina", "Dmitriy"};
	static int index;
	
	static String next() {return names[index++%names.length];}
	
	
	
	
}



public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArrayList<String> al = new ArrayList<String>();
LinkedList<String> ll = new LinkedList<String>();
HashSet<String> hs= new HashSet<String>();		
LinkedHashSet<String> lhs= new LinkedHashSet<String>();	
TreeSet<String> ts= new TreeSet<String>();


for (int i=0;i<10;i++)		al.add(FamilyName.next());
for (int i=0;i<10;i++)		ll.add(FamilyName.next());
for (int i=0;i<10;i++)		hs.add(FamilyName.next());
for (int i=0;i<10;i++)		lhs.add(FamilyName.next());
for (int i=0;i<10;i++)		ts.add(FamilyName.next());
	
	System.out.println(al);
	System.out.println(ll);
	System.out.println(hs);
	System.out.println(lhs);
	System.out.println(ts);		
		
	}

}
