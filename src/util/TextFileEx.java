package util;

import java.io.*;
import java.util.*;

public class TextFileEx extends ArrayList<String> {
  // Read a file as a single string:
  public static String read(String fileName) throws IOException {
    StringBuilder sb = new StringBuilder();
      BufferedReader in= new BufferedReader(new FileReader(
        new File(fileName).getAbsoluteFile()));
        String s;
      while((s = in.readLine()) != null) {
    sb.append(s);
    sb.append("\n");
  }
  in.close();
return sb.toString();
}
//Write a single file in one method call:
public static void write(String fileName, String text) throws IOException{
PrintWriter out = new PrintWriter(
  new File(fileName).getAbsoluteFile());
  out.print(text);
  out.close();
 }
//Read a file, split by any regular expression:
public TextFileEx(String fileName, String splitter)  throws IOException{
super(Arrays.asList(read(fileName).split(splitter)));
// Regular expression split() often leaves an empty
// String at the first position:
if(get(0).equals("")) remove(0);
}
//Normally read by lines:
public TextFileEx(String fileName) throws IOException {
this(fileName, "\n");
}
public void write(String fileName)  throws IOException{
PrintWriter out = new PrintWriter(
  new File(fileName).getAbsoluteFile());
  for(String item : this)
    out.println(item);
  out.close();
}
//Simple test:
public static void main(String[] args) throws IOException{
String file = read("TextFile.java");
write("test.txt", file);
TextFileEx text = new TextFileEx("test.txt");
text.write("test2.txt");
// Break into unique sorted list of words:
TreeSet<String> words = new TreeSet<String>(
new TextFileEx("TextFile.java", "\\W+"));
// Display the capitalized words:
System.out.println(words.headSet("a"));
}
}
