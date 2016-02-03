package chapter10;
import java.util.*;


 class Stack<T> {
	 private LinkedList<T> storage = new LinkedList<T>();
	 public void push(T v) { storage.addFirst(v); }
	 public T peek() { return storage.getFirst(); }
	 public T pop() { return storage.removeFirst(); }
	 public boolean empty() { return storage.isEmpty(); }
	 public String toString() { return storage.toString(); }
	} 


public class Ex15 {

	public static void main(String[] Args) {
		
		Stack<Character> st = new Stack<Character>();
		
		String eval = "+U+n+c-+e+r+t-+a-+i-+n+t+y-+-+r+u-+l+e+s-";
		
		for (Character c: eval.toCharArray()) {
			switch(c){ 
			case '-': System.out.print(st.pop()); break;
			case '+': break;//ready to push
			default: st.push(c); 	
			}
		}
		
		
		
	}
	
	
}
