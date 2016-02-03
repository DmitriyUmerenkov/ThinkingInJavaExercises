package chapter10;
import java.util.*;



public class Ex28 {

	public static void main(String[] Args) {
		
		PriorityQueue<Double>q = new PriorityQueue<Double>();
		Random r = new Random();
		
		for (int i=0;i<10;i++) q.offer(r.nextDouble());
		
		while (q.peek()!=null) System.out.println(q.poll());
		
	}
	
}
