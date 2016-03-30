package io;

import java.io.File;

import util.BinaryFile;
import util.ProcessFiles;

public class Ex20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Looking for .class files ");
			new ProcessFiles(new ProcessFiles.Strategy() {
			      public void process(File file) {
			    	try {byte[] buffer = BinaryFile.read(file);
			    	System.out.println("Found file "+ file.getName()+" First four bytes:"+String.format("%02X", buffer[0])+String.format("%02X", buffer[1])+String.format("%02X", buffer[2])+String.format("%02X", buffer[3]));
			    	} catch (Exception e) {}
			    	
			      }
			    }, ".*\\.class").start(args);	
	}

}
