package io;

import java.io.*;


public class Ex13 {
  static String file = "BasicFileOutput.out";
  public static void main(String[] args)
  throws IOException {
	  LineNumberReader in = new LineNumberReader(
      new StringReader(
        BufferedInputFile.read("test.txt")));
    PrintWriter out = new PrintWriter(
      new BufferedWriter(new FileWriter(file)));
    String s;
    while((s = in.readLine()) != null )
      out.println(in.getLineNumber() + ": " + s);
    out.close();
    // Show the stored file:
    System.out.println(BufferedInputFile.read(file));
  }
}