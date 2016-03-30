package io;

import java.io.File;
import java.util.*;

import util.Directory;
import util.PPrint;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String regex =".*sa.*";
		
		Directory.TreeInfo tinf=Directory.walk(".",regex);

		System.out.println("regex = "+ regex);
		
		int totalsize=0;
		for (File f: tinf) {
			totalsize+=f.length();
			System.out.println(f.getName());
		}
System.out.println("Total size = "+ totalsize);
	
	}
	
	

}
