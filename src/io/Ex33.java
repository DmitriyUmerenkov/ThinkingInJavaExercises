package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.prefs.*;
import java.io.*;

public class Ex33 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stubsrc
		
		Preferences prefs =Preferences.userNodeForPackage(Ex33.class);
		String bd= prefs.get("base directory", ".");
		System.out.println("Base direcotry is:"+ bd);
		System.out.println("Input new direcotry, blank line exits");
		
		  BufferedReader stdin = new BufferedReader(
			      new InputStreamReader(System.in));
			String s = stdin.readLine();
			File newdir= new File(s);
			if (newdir.exists() && newdir.isDirectory())
			{
				System.out.println("Setting new directory to "+s);
				prefs.put("base directory",s);
			}
			else 	System.out.println("Wrong directory, exiting");		
	}

}
