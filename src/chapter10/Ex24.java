package chapter10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex24 {

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		Map<Integer, String> m = new LinkedHashMap<Integer, String>();
		m.put(21, "Two");
		m.put(41, "Four");
		m.put(61, "Six");
		m.put(11, "One");
		m.put(31, "Three");
		m.put(51, "Five");


		
//		for (Integer i: m.keySet()) System.out.println(i + " " + m.get(i));
	System.out.println(m);	
		ArrayList<Integer> al =  new ArrayList<Integer>(m.keySet());
		al.sort(null);
		LinkedHashMap<Integer, String> sm = new LinkedHashMap<Integer, String>();
		for (Integer i: al) {
			sm.put(i, m.get(i));
		}
		m=sm;
		System.out.println(m);	
		
		
		
	}
	
}
