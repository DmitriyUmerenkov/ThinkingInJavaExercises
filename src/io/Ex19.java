package io;
import java.util.*;
import util.*;
import java.io.*;



public class Ex19 {

	public static void main(String[] args) throws IOException {
		  if (args.length==0) System.exit(0);
		    
		    Map<Byte,Integer> freq = new TreeMap<Byte,Integer>();
		    
		    byte[] buffer= BinaryFile.read(new File(args[0]));
		    
		    	for (Byte b: buffer)
		    		freq.put(b, freq.get(b)==null?0:freq.get(b)+1);
		   	System.out.println(freq);		
	}

}
