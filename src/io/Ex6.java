package io;

import java.io.File;

import util.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class Ex6 {

	public static void main(String[] args) {
try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		final Date d = sdf.parse("02/20/2016 00:00:00");	
System.out.println("Looking for files modified after "+sdf.format(d));
		new ProcessFiles(new ProcessFiles.Strategy() {
		      public void process(File file) {
		    	if (file.lastModified()>d.getTime())  
    		        System.out.println(file);
		      }
		    }, ".*\\.java").start(args);	}

	 catch (Exception e) {}
   }
}

