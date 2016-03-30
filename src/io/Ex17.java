package io;
import java.util.*;
import util.*;



public class Ex17 {

	public static void main(String[] args) {
    if (args.length==0) System.exit(0);
    
    Map<Character,Integer> freq = new HashMap<Character,Integer>();
    Iterator<String> it = (new TextFile(args[0])).iterator();
    while (it.hasNext())
    	for (Character c: it.next().toCharArray())
    		freq.put(c, freq.get(c)==null?0:freq.get(c)+1);
   	System.out.println(freq);		
	}

}
