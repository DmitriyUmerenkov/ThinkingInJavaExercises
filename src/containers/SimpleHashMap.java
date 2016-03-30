package containers;

import java.util.*;


import util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
  // Choose a prime number for the hash table
  // size, to achieve a uniform distribution:
  static int SIZE = 1; // not final as it is changed by rehash
  // You can’t have a physical array of generics,
  // but you can upcast to one:
  
  
  @SuppressWarnings("unchecked")
  LinkedList<MapEntry<K,V>>[] buckets =
    new LinkedList[SIZE];
  
  
  
  private static boolean isPrime(int num) {
      if (num % 2 == 0)
          return false;
      for (int i = 3; i * i <= num; i += 2)
          if (num % i == 0) return false;
      return true;
}  
  
  private void rehash() {
	  int NewSize = SIZE*2;
	  
	  while (!isPrime(NewSize++));
	  
	  LinkedList<MapEntry<K,V>>[] newbuckets =
			    new LinkedList[NewSize];

	  for (Map.Entry<K,V> en: this.entrySet()) {
		 
		    int index = Math.abs(en.getKey().hashCode()) % NewSize;
		    if(newbuckets[index] == null)
		      newbuckets[index] = new LinkedList<MapEntry<K,V>>();
		
		    newbuckets[index].add((MapEntry<K,V>)en);		  		  
	  }
	  
	  SIZE=NewSize;
	  buckets=newbuckets;
 }
  
  
  
  public V put(K key, V value) {
	  if (size()>SIZE) rehash();

	  V oldValue = null;
    int index = Math.abs(key.hashCode()) % SIZE;
    if(buckets[index] == null)
      buckets[index] = new LinkedList<MapEntry<K,V>>();
    LinkedList<MapEntry<K,V>> bucket = buckets[index];
    MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
    boolean found = false;
    ListIterator<MapEntry<K,V>> it = bucket.listIterator();
   // int probes=0;
    while(it.hasNext()) {
    //	probes++;	
    	MapEntry<K,V> iPair = it.next();
    //  if(!iPair.getKey().equals(key)) System.out.println("HashCode collision on put, have key:"+key+" hascode:"+key.hashCode()+" found key:"+iPair.getKey()+" hashcode:"+ iPair.getKey().hashCode());
      if(iPair.getKey().equals(key)) {
        oldValue = iPair.getValue();
        it.set(pair); // Replace old with new
        found = true;
        break;
} }
   // System.out.println("put() probes for key "+ key+" :"+probes);
    if(!found)
      buckets[index].add(pair);
    return oldValue;
  }
  public V get(Object key) {
    int index = Math.abs(key.hashCode()) % SIZE;
    if(buckets[index] == null) return null;
  //  int probes=0;
    for(MapEntry<K,V> iPair : buckets[index])
    {
  //      probes++;
   // 	if(!iPair.getKey().equals(key)) System.out.println("HashCode collision on put, have key:"+key+" hascode:"+key.hashCode()+" foune key:"+iPair.getKey()+" hashcode:"+ iPair.getKey().hashCode());
    	if(iPair.getKey().equals(key))
        return iPair.getValue();
    }
  //  System.out.println("get() probes for key "+ key+" :"+probes);
    return null;
  }
  
  @Override
  public V remove(Object key) {

	  int index = Math.abs(key.hashCode()) % SIZE;
	    if(buckets[index] == null) return null;
	    for(MapEntry<K,V> iPair : buckets[index])
	    {
	    	if(iPair.getKey().equals(key))
	    	{
	    		buckets[index].remove(iPair);
	    		return iPair.getValue();
	    	}
	    }
	    return null;

  }
  
  public void clear() {
	  buckets = new LinkedList[SIZE];
  }
  
  
  
  
  public class SimpleHashEntrySet extends HashSet<Map.Entry<K, V>> {
		 
	  private class Iter implements Iterator<Map.Entry<K, V>> {
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
		public java.util.Map.Entry<K, V> next() {
			if (buckets[bucket]!=null && position<buckets[bucket].size()-1) { position++; return buckets[bucket].get(position);} //No bucket change
			
			for (int localBucket=bucket+1;localBucket<SIZE;localBucket++)
			 if (buckets[localBucket]!=null && buckets[localBucket].size()>0) { bucket=localBucket; position=0; return buckets[bucket].get(0);} //First next non-empty bucket
			
			return null;  //Last element
		}
		
		@Override
		public void remove(){
			boolean toTop          =true;
			SimpleHashEntrySet.this.remove(buckets[bucket].get(position));
			
			if (position>=0) {position--;toTop=false;}
			else 			
			 for (int localBucket=bucket;localBucket>=0;localBucket--)
			 {
				 if (buckets[localBucket]!=null && buckets[localBucket].size()>0) {bucket=localBucket; position=buckets[localBucket].size()-2;toTop=false;}
			 }
			 if (toTop) {bucket=0;position=-1;}
				 
		}	    
	  }
	  @Override 
		public Iterator<Map.Entry<K, V>> iterator() {return new Iter();}
	  
	  
	  @Override
	  public boolean remove(Object o) {
		if (!contains(o)) return false;
		else {
			SimpleHashMap.this.remove(((Map.Entry<K,V>)o).getKey());
			return super.remove(o);
		}
	}
	 
	 @Override
	  public void clear() {
		 SimpleHashMap.this.clear();
		 super.clear();
	 } 
	
}
  
  public Set<Map.Entry<K,V>> entrySet() {
    Set<Map.Entry<K,V>> set= new SimpleHashEntrySet();
    for(LinkedList<MapEntry<K,V>> bucket : buckets) {
      if(bucket == null) continue;
      for(MapEntry<K,V> mpair : bucket)
        set.add(mpair);
    }
return set; }
  public static void main(String[] args) {
	  SimpleHashMap<String,String> m= new SimpleHashMap<String,String>();
	    m.putAll(Countries.capitals(15));
	    System.out.println(m);
	    System.out.println(m.get("BULGARIA"));
	    System.out.println(m.entrySet());
	    m.entrySet().remove(m.entrySet().iterator().next());
	    System.out.println(m); 
	    m.entrySet().remove(m.entrySet().iterator().next());
	    System.out.println(m);
	    m.entrySet().removeAll(m.entrySet());
	    System.out.println(m);

  }
}
