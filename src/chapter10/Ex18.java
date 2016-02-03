package chapter10;

import java.util.*;


public class Ex18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(11, "One");
		m.put(21, "Two");
		m.put(31, "Three");
		m.put(41, "Four");
		m.put(51, "Five");
		m.put(61, "Six");
		
//		for (Integer i: m.keySet()) System.out.println(i + " " + m.get(i));
	System.out.println(m);	
		ArrayList<Integer> al =  new ArrayList<Integer>(m.keySet());
		al.sort(null);
		LinkedHashMap<Integer, String> sm = new LinkedHashMap<Integer, String>();
		for (Integer i: al) {
			sm.put(i, m.get(i));
		}
		
		System.out.println(sm);	
		
		
		
	}

}
