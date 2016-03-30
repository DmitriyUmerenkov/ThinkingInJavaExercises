package containers;
import java.util.*;
import util.*;

public class mySortedSet<T> extends LinkedList<T> implements SortedSet<T>{

	Comparator<? super T> myComparator;
	
	public mySortedSet() {super();}
	public mySortedSet (Comparator<? super T> comp) {super(); myComparator=comp;};
	public mySortedSet (Collection <? extends T> objs, Comparator<? super T> comp) 
	{
		super();
		myComparator=comp;
		this.addAll(objs);
		
	}
	public mySortedSet (Collection <? extends T> objs) 
	{
		super(); 
		this.addAll(objs);
	}


	
	@Override
	public Comparator<? super T> comparator() {
		// TODO Auto-generated method stub
		return myComparator;
	}
	
	@Override
	public boolean add(T obj){
		if (this.contains(obj)) return false;
		else {
			if (size()==0) 
			{ 
			   if(myComparator == null && !(obj instanceof java.lang.Comparable))
					throw new RuntimeException("Uncomparable elements exception");
				super.add(obj);
			}
			else
			if (myComparator==null)
			{
				int i;
				for (i=0;i<size();i++)
					if (((java.lang.Comparable)obj).compareTo(get(i))<0) break;
					super.add(i, obj);
			
			}
			else
			{
				int i=0;
				for (i=0;i<size();i++)
					if (myComparator.compare(obj, get(i))<0) break;
					super.add(i, obj);
			}
   		    return true;
   		    }	
		}
		
	
	@Override
	public boolean addAll(Collection <? extends T> objs){
		boolean added=false;
		for (T obj: objs)
			if (!this.contains(obj)) {add(obj); added=true;}
		return added;
	}	
	
	
	
	public T first() {return get(0);}
	public T last() {return get(this.size());}
	
	
	
	public mySortedSet<T> subSet (T fromElement, T toElement)
	{
		return new mySortedSet<T>(this.subList(this.indexOf(fromElement), this.indexOf(toElement)), this.myComparator);		
	}

	
	
	public mySortedSet<T> headSet(T toElement)
	{
		return new mySortedSet<T>(this.subList(0, this.indexOf(toElement)), this.myComparator);		
	}
	public mySortedSet<T> tailSet(T fromElement)
	{
		return new mySortedSet<T>(this.subList(this.indexOf(fromElement), this.size()), this.myComparator);		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mySortedSet<String> aSet1= new mySortedSet<String>(CollectionData.list(new RandomGenerator.String(), 10));
		
		System.out.println(aSet1);
		aSet1.addAll(aSet1);
		aSet1.addAll(aSet1);
		System.out.println(aSet1);
		
		mySortedSet<String> aSet2= new mySortedSet<String>(CollectionData.list(new RandomGenerator.String(), 10), String.CASE_INSENSITIVE_ORDER);
		
		System.out.println(aSet2);
		aSet1.addAll(aSet2);
		aSet1.addAll(aSet2);
		System.out.println(aSet2);

		System.out.println(aSet1.comparator());
		System.out.println(aSet2.comparator());
		
		mySortedSet<Ex9> aSet3 = new mySortedSet<Ex9>();
		// aSet3.add(new Ex9()); Runtime Uncomparable elements exception
		
		System.out.println(aSet2.headSet(aSet2.get(2)));
		System.out.println(aSet2.tailSet(aSet2.get(4)));
		System.out.println(aSet2.subSet(aSet2.get(2), aSet2.get(4)));
		
		
		
	}
	

}
