package chapter3;

import java.util.Random;

public class Ex1to2 {

	public static void main(String[] args) {
	for (int i=1;i<101;i++) System.out.print(i+ " "); 
	Random r = new Random();
	for (int i=0;i<25;i++)
		if (r.nextInt()>r.nextInt()) System.out.println("FIRST");
		else System.out.println("SECOND");
	
	
	}

}
