package containers;

import java.util.*;

import util.TextFile;

public class Ex15and19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		SlowMap<String,Integer> counter = new SlowMap<>();
		
		  TextFile tf = new TextFile("TextFile.java", "[\\p{Punct}\\s]+");
		  for (String st: tf) 
			  counter.put(st, counter.get(st)==null?1:counter.get(st)+1);
			  	  
		  System.out.println(counter);
		  
			SimpleHashMap<String,Integer> counterh = new SimpleHashMap<>();
			
			  tf = new TextFile("TextFile.java", "[\\p{Punct}\\s]+");
			  for (String st: tf) 
				  counterh.put(st, counterh.get(st)==null?1:counterh.get(st)+1);
				  	  
			  System.out.println(counter);


	}

}
