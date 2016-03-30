package containers;

import java.util.*;
import static util.Print.*;

public class SlowSet<T> extends AbstractSet<T>{

	private List<T> data = new ArrayList<T>();
	
	@Override
	public boolean add(T t){
		if (contains(t)) return false;
		else data.add(t); return true;
		}
	@Override
	public void clear(){data.clear();}
	@Override
	public Object clone(){
		SlowSet<T> aClone = new SlowSet<T>();
		aClone.data=this.data;
		return aClone;
	}
	@Override
	public boolean contains(Object o){return data.contains(o);}
	@Override
	public boolean isEmpty(){return data.isEmpty();}
	@Override
	public boolean remove(Object o){
		if (!data.contains(o)) return false;
		else return data.remove(o);
		}

	
	

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			int position;
			@Override
			public boolean hasNext() {
				if (position<data.size()) return true;
				else return false;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				;
				return data.get(position++);
			}
			
		public void remove() 
		{
			data.remove(position--);
						
		}	
		};
		
		
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return data.size();
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
		    
		    set1 = new SlowSet<String>();
		    Collections.addAll(set1,
		      "A B C D E F G H I J K L".split(" "));
		    set1.add("M");
		    print("H: " + set1.contains("H"));
		    print("N: " + set1.contains("N"));
		    set2 = new SlowSet<String>();
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
