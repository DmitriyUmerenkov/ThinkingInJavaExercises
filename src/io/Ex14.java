package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class Ex14 {
	static String file = "BasicFileOutput.out";
	  public static void main(String[] args)
	  throws IOException {
	    BufferedReader in = new BufferedReader(
	      new StringReader(
	        BufferedInputFile.read("test.txt")));
	    PrintWriter out = new PrintWriter(
	      new BufferedWriter(new FileWriter(file)));
	    int lineCount = 1;
	    String s;
	    long time=System.nanoTime();
	    while((s = in.readLine()) != null )
	      out.println(lineCount++ + ": " + s);
	    out.close();
	    time=System.nanoTime()-time;
	    // Show the stored file:
	   // System.out.println(BufferedInputFile.read(file));
	    System.out.println("Buffered operation took "+ time+ " ns");
	  
	    BufferedReader in2 = new BufferedReader(
	  	      new StringReader(
	  		        BufferedInputFile.read("test.txt")));
	  	    PrintWriter out2 = new PrintWriter(new FileWriter(file));
	  	   
	  		time=System.nanoTime();
	  	    while((s = in2.readLine()) != null )
	  	      out2.println(lineCount++ + ": " + s);
	  	    out2.close();
	  	    time=System.nanoTime()-time;
	  	    // Show the stored file:
	  	   // System.out.println(BufferedInputFile.read(file));
	  	    System.out.println("Unbuffered operation took "+ time+ " ns");
	  	  
	  
	  
	  
	  
	  
	  }
}
