package containers;

import java.util.Iterator;

public class SList<T> {
	
	Link<T> top=new Link<T>();
	
	private static class Link<T> {
		T value;
		Link<T> next;
		Link(T value) {this.value=value;}
		Link(){}
			}
	
	public class SListIterator<T> /*implements Iterator<T>*/ {
		private Link<T> current;
		private Link<T> previous;
		{current=(Link<T>)top;}
		
		
		public boolean hasNext() {
			if (current.next!=null) return true;
			else return false;
		}

		
		public T next() {
			// TODO Auto-generated method stub
			previous=current;
			current=current.next;
			return current.value;
			}
		
		public void add (T value) {
			Link<T> adding = new Link<T>(value);
			adding.next=current.next;
			current.next=adding;


			}
	
		public void remove() {
			previous.next=current.next;
			current=previous;;
		}		
	}
	
	public SListIterator<T> iterator() {return new SListIterator();}
	
	
	
	public String toString() {
		SListIterator it = this.iterator();
		StringBuilder sb= new StringBuilder();
		while(it.hasNext()) sb.append(it.next().toString()+ " ");
		return sb.toString();
	}	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SList<String> myList = new SList<String>();
		SList.SListIterator it = myList.iterator();
		it.add("first");
		it.add("second");
		it.add("third");
		it.add("fourth");
		
		System.out.println(myList);
		
		SList.SListIterator it2 = myList.iterator();
		
		it2.next(); it2.next(); it2.remove();
		System.out.println(myList);
		
		
	}

}
