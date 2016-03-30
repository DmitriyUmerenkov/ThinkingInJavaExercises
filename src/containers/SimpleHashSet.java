package containers;

import static util.Print.print;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import containers.SimpleHashMap.SimpleHashEntrySet;

public class SimpleHashSet<T> extends AbstractSet<T>{
	  static final int SIZE = 2;
		  @SuppressWarnings("unchecked")
	  LinkedList<T>[] buckets = new LinkedList[SIZE];
	
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			int bucket;
			int position=-1;
			@Override
			public boolean hasNext() {
				if (buckets[bucket]!=null && position<buckets[bucket].size()-1) return true; //No bucket change
				
				for (int localBucket=bucket+1;localBucket<SIZE;localBucket++)
				 if (buckets[localBucket]!=null && buckets[localBucket].size()>0) return true; //First next non-empty bucket
				
				return false; //Last element
			}

			@Override
			public T next() {
				if (buckets[bucket]!=null && position<buckets[bucket].size()-1) { position++; return buckets[bucket].get(position);} //No bucket change
				
				for (int localBucket=bucket+1;localBucket<SIZE;localBucket++)
				 if (buckets[localBucket]!=null && buckets[localBucket].size()>0) { bucket=localBucket; position=0; return buckets[bucket].get(0);} //First next non-empty bucket
				
				return null;  //Last element

			}
			
		public void remove() 
		{
			boolean toTop=true;
			buckets[bucket].remove(buckets[bucket].get(position));
			
			if (position>=0) {position--;toTop=false;}
			else 			
			 for (int localBucket=bucket;localBucket>=0;localBucket--)
			 {
				 if (buckets[localBucket]!=null && buckets[localBucket].size()>0) {bucket=localBucket; position=buckets[localBucket].size()-2;toTop=false;}
			 }
			 if (toTop) {bucket=0;position=-1;}
						
		}	
		};
	}

	
	
	
	
	
	
	@Override
	public int size() {
		int result=0;
		for (int i=0;i<SIZE;i++) if(buckets[i]!=null) result+=buckets[i].size();
				return result;	
	}
	
	@Override
	public boolean add(T t){
		int index=Math.abs(t.hashCode())%SIZE;
		if (buckets[index]==null) buckets[index] = new LinkedList<T>();
		if (buckets[index].contains(t)) return false;
		else return buckets[index].add(t);	
		}
	@Override
	public void clear(){buckets = new LinkedList[SIZE];}
	@Override
	public Object clone(){
		SimpleHashSet<T> aClone = new SimpleHashSet<T>();
		aClone.buckets=this.buckets;
		return aClone;
	}
	@Override
	public boolean contains(Object o){
		boolean result=false;
		for (int i=0;i<SIZE;i++) if(buckets[i]!=null && buckets[i].contains(o)) result=true;
				return result;	
	}
	
	@Override
	public boolean isEmpty(){
		boolean result=true;
		for (int i=0;i<SIZE;i++) if(!(buckets[i]==null || buckets[i].isEmpty())) result=false;
				return result;}
	@Override
	
	
	public boolean remove(Object o){
		int index=Math.abs(o.hashCode())%SIZE;
		if (buckets[index]!=null && buckets[index].contains(o)) 
		{
			return buckets[index].remove(o);
		}
		else return false;	
	}

	
	
	
	
	public static void main(String[] args) {
		   Set<String> set1 = new HashSet<String>();
		    Collections.addAll(set1,
		      "A B C D E F G H I J K L".split(" "));
		    set1.add("M");
		    print("H: " + set1.contains("H"));
		    print("N: " + set1.contains("N"));
		    Set<String> set2 = new HashSet<String>();
		    Collections.addAll(set2, "H I J K L".split(" "));
		    print("set2 in set1: " + set1.containsAll(set2));
		    set1.remove("H");
		    print("set1: " + set1);
		    print("set2 in set1: " + set1.containsAll(set2));
		    set1.removeAll(set2);
		    print("set2 removed from set1: " + set1);
		    Collections.addAll(set1, "X Y Z".split(" "));
		    print("‘X Y Z’ added to set1: " + set1);
		    
		    print("*********************************************");
		    
		    set1 = new SimpleHashSet<String>();
		    Collections.addAll(set1,
		      "A B C D E F G H I J K L".split(" "));
		    set1.add("M");
		    print("H: " + set1.contains("H"));
		    print("N: " + set1.contains("N"));
		    set2 = new SimpleHashSet<String>();
		    Collections.addAll(set2, "H I J K L".split(" "));
		    print("set2 in set1: " + set1.containsAll(set2));
		    set1.remove("H");
		    print("set1: " + set1);
		    print("set2 in set1: " + set1.containsAll(set2));
		    set1.removeAll(set2);
		    print("set2 removed from set1: " + set1);
		    Collections.addAll(set1, "X Y Z".split(" "));
		    print("‘X Y Z’ added to set1: " + set1);
	}

	
	
	
	
	
	
	
	
	
	

}
