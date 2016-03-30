package io;

import java.util.regex.*;
import java.io.*;
import java.util.*;

public class SortedDirList {
	private String[] list;
	
	SortedDirList(File f) {
		list=f.list();
		Arrays.sort(list);
	}
	
	String[] list() {return list;}
	String[] list(String regex) {
		List<String> result = new ArrayList<String>();
		Pattern p = Pattern.compile(regex);
		
		for (int i=0;i<list.length;i++)
			if (p.matcher(list[i]).matches()) result.add(list[i]);
	return result.toArray(new String[0]);
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    SortedDirList sdl = new SortedDirList(new File("."));
	    
	    System.out.println(Arrays.deepToString(sdl.list()));
	    System.out.println(Arrays.deepToString(sdl.list(".*?test.*?")));
	    
	}

}
