package io;

import java.util.regex.*;
import java.io.*;
import java.util.*;
import util.*;

public class DirList3 {
  public static void main(final String[] args) {
    int length=0;
	  File path = new File(".");
    String[] list;
    if(args.length == 0)
      list = path.list();
    else
      list = path.list(new FilenameFilter() {
        private Pattern pattern = Pattern.compile(args[0]);
        public boolean accept(File dir, String name) {
        	if (new File(dir, name).isDirectory()) return false;
       TextFile tf = new TextFile(name);
       for (String s: tf.toArray(new String[0]))
    	   if (pattern.matcher(s).matches()) return true;
        return false;
        }
      });
  
    Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
    for(String dirItem : list)
    {
       length+=new File(path, dirItem).length();
    	System.out.println(dirItem);
    }
    System.out.println("Total length = "+length);
  }
}