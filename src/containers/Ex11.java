package containers;
import java.util.*;

class IntWrapper implements Comparable<IntWrapper> {
	private final int value;
	IntWrapper (int i) {value=i;}
	public int getValue() {return value;}
	
	@Override
	public int compareTo(IntWrapper o) {
		// TODO Auto-generated method stub
		if (value>o.getValue()) return 1;
		else if (value==o.getValue()) return 0;
		else return -1;

	}
	
	public String toString() {return ""+value;}
	
}


public class Ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random(47);
		IntWrapper[] ar = new IntWrapper[20];
		
		for (int i=0; i<20 ;i++) ar[i]=new IntWrapper(r.nextInt(100));
 
		PriorityQueue<IntWrapper> pq = new PriorityQueue<IntWrapper>();
		pq.addAll(Arrays.asList(ar));
		
		System.out.println(Arrays.toString(ar));
		System.out.println(pq);

		while (pq.peek()!=null) System.out.println(pq.poll());
		
		
	}

}
