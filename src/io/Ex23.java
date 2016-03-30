package io;

import java.nio.*;
import java.io.*;
import java.nio.channels.*;
import java.awt.event.*;



class CBPrint {
	
	  public static boolean isPrintableChar( char c ) {
	        Character.UnicodeBlock block = Character.UnicodeBlock.of( c );
	        return (!Character.isISOControl(c)) &&
	                c != KeyEvent.CHAR_UNDEFINED &&
	                block != null &&
	                block != Character.UnicodeBlock.SPECIALS;
	    }
	  
	static String print (CharBuffer cb) {
		StringBuilder result=new StringBuilder();
		Character curr;
		cb.flip();	
		while (cb.hasRemaining()) 
		    if (isPrintableChar(curr=cb.get())) 
				result.append(curr);
			else break;
		
		
		
		
		
		return result.toString();
	}
	
	
	
	
}



public class Ex23 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ByteBuffer buffer= ByteBuffer.allocate(1024);
		CharBuffer cbuffer = CharBuffer.allocate(1024);
		if (args.length==0) System.exit(0);
		StringBuilder result = new StringBuilder();
		FileChannel fc = new FileInputStream(args[0]).getChannel();
		Boolean nonprint=false;
		
		while(fc.read(buffer)!=-1 && !nonprint)
		{
		  buffer.flip();
		    while (buffer.remaining()>0) cbuffer.put((char)buffer.get());
		  buffer.clear();
			  
		  result.append(CBPrint.print(cbuffer));
		  if (cbuffer.remaining()>0) nonprint=true;
		  cbuffer.clear();
		}
		fc.close();
		
		
		System.out.println(result);
	}

}
