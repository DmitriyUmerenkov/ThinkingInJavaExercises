package chapter10;
import java.util.*;

public class Ex14 {

	
	public static void main (String Args[]) {
		
		LinkedList<Integer> MyList = new LinkedList<Integer>();
		
		ListIterator<Integer> it = MyList.listIterator();
		//Random r = new Random();
		
		for (int i=0;i<20;i++) {
			it.add(i); if(i>0 && i%2==0) it.previous();
			
			
		}
		
		
		System.out.println(MyList);
		
		
		
	}
	
}
