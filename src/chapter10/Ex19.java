package chapter10;
import java.util.*;


public class Ex19 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> m = new HashSet<String>();
		m.add("One");
		m.add("Two");
		m.add("Three");
		m.add("Four");
		m.add("Five");
		m.add("Six");
		
//		for (Integer i: m.keySet()) System.out.println(i + " " + m.get(i));
	System.out.println(m);	
		
	ArrayList<String> al =  new ArrayList<String>(m);
		al.sort(null);
		LinkedHashSet<String> sm = new LinkedHashSet<String>();
		for (String s: al) {
			sm.add(s);
		}
		
		System.out.println(sm);	
		
		
		
	}
	
}
