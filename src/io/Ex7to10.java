package io;
import java.io.*;
import java.util.*;

public class Ex7to10 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if (args.length<2) System.exit(0);
			
			BufferedReader in = new BufferedReader(
			      new FileReader(args[0]));		
		 List<String> fileList = new LinkedList<String>();
		 
		 String current;
		 
		 PrintWriter out = new PrintWriter(
			      new BufferedWriter(new FileWriter(args[0]+"-out")));
		 
		 while((current=in.readLine())!=null)
			 fileList.add(current);	
		 in.close();
		 	ListIterator<String> it = fileList.listIterator(fileList.size());
		 	int index=fileList.size();
		 	while (it.hasPrevious()) 
		    {
		 	  current=it.previous();
		 	  out.println(--index+" : " + current);
		 	  for (int i=1; i<args.length;i++)
		 	 	if (current.contains(args[i]))
			 		System.out.println(current);
			  
		 	}
		 	out.close();
		 	System.out.println(BufferedInputFile.read(args[0]+"-out"));
	}

}
