package chapter8;

import java.nio.*;
import java.util.*;

class CharSequence implements Readable{
	static int count=2;
	public int read(CharBuffer cb) {
		if (count--==0) return -1;
		
		
		Random r = new Random();
		for (int i=0;i<3;i++) cb.append((char)(r.nextInt(256)));	
		
		
	return 3;
		
	}
	
	
	
}


public class Ex16 {

	public static void main (String[] args) {
Scanner s=new Scanner(new CharSequence());
		while (s.hasNext()){
			System.out.println(s.next());
			System.out.println();
	
		}
				s.close();
	}
	
	
}
