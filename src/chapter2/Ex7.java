package chapter2;

import java.util.*;

public class Ex7 {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		for (int i=0;i<10;i++) {
			if (r.nextBoolean()==true) System.out.println("HEAD");
			else System.out.println("TAILS");
		}
		
		

	}

}
