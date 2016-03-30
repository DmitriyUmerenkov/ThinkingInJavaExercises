package containers;


import java.util.*;

import containers.SlowMap.SlowEntrySet;
import util.*;

public class SlowMap2<K,V> extends AbstractMap<K,V> implements Map<K,V>{
  private List<MapEntry<K,V>> data = new ArrayList<MapEntry<K,V>>(); 
	

  public V put(K key, V value) {
	  V oldvalue;
	  MapEntry<K,V> newEntry = new MapEntry<K,V>(key,value);
	  for (int i=0;i<data.size();i++) {
		  if (data.get(i).getKey()==key) {
			  oldvalue=data.get(i).getValue();
			  data.set(i, newEntry);
			  return oldvalue;
		  }
	 }
	  data.add(newEntry);
	  return null;
	  
  }
  public V get(Object key) { // key is type Object, not K
	  for (int i=0;i<data.size();i++)
		  if (data.get(i).getKey()==key) return data.get(i).getValue();
      return null;
  }

  @Override
  public V remove(Object key) {
	  V oldValue;
	  for (int i=0;i<data.size();i++)
		  if (data.get(i).getKey()==key) { 
			  oldValue=data.get(i).getValue();
			  data.remove(i);
			  return oldValue;
		  }
      return null;
 
  }
  
  public void clear() {
  data.clear();  
}
  
  
  public class SlowEntrySet extends HashSet<Map.Entry<K, V>> {
	 
	  private class Iter implements Iterator<Map.Entry<K, V>> {
		  int position;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if (position<SlowEntrySet.this.size()) return true;
			return false;
		}

		@Override
		public java.util.Map.Entry<K, V> next() {
			// TODO Auto-generated method stub
			position++;
			return SlowMap2.this.data.get(position-1);
		}
		@Override
		public void remove(){
			SlowEntrySet.this.remove(SlowMap2.this.data.get(position-1));
	//		SlowMap2.this.data.remove(position-1);
			position--;
		}	    
	   } 
	  @Override 
		public Iterator iterator() {return new Iter();}
	  
	  
	  @Override
	  public boolean remove(Object o) {
		if (!contains(o)) return false;
		else {
			SlowMap2.this.remove(((Map.Entry<K,V>)o).getKey());
			return super.remove(o);
		}
	}
	 
	 @Override
	  public void clear() {
		 SlowMap2.this.clear();
		 super.clear();
	 } 
	
}
 
  
  public Set<K> keySet() {
	
	  return new HashSet<K>() {
		  {
			  for (Map.Entry<K, V> en: SlowMap2.this.entrySet())
				  this.add(en.getKey());			  
		  }
		  
		  
		  class Iter implements Iterator<K> {
			  int position;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				if (position<SlowMap2.this.entrySet().size()) return true;
				return false;
			}

			@Override
			public K next() {
				// TODO Auto-generated method stub
				position++;
				return SlowMap2.this.data.get(position-1).getKey();
			}
			@Override
			public void remove(){
				SlowMap2.this.keySet().remove(SlowMap2.this.data.get(position-1).getKey());		
				position--;
			}	    
		  }
		  @Override 
			public Iterator<K> iterator() {return new Iter();
			}
		  
		  
		  
		  @Override
		  public boolean remove (Object key) {
			  if (!(contains(key))) return false;
			  SlowMap2.this.remove(key);
			  super.remove(key);  
			  return true;
		  }
		  @Override
		  public void clear() {
				 SlowMap2.this.clear();
				 super.clear();
			 } 
	  };
  }
  
  /*
  public Collection<V> Values() {
		
	  return new ArrayList<V>() {
		  {
			  this.addAll(SlowMap2.this.values);
		   }
		  
		  
		  class Iter implements Iterator<V> {
			  int position;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				if (position<SlowMap2.this.values.size()) return true;
				return false;
			}

			@Override
			public V next() {
				// TODO Auto-generated method stub
				position++;
				return SlowMap2.this.values.get(position-1);
			}
			@Override
			public void remove(){
				SlowMap2.this.Values().remove(SlowMap2.this.values.get(position-1));		
				position--;
			}	    
		  }
		  @Override 
			public Iterator<V> iterator() {return new Iter();
			}
		  
		  
		  
		  @Override
		  public boolean remove (Object value) {
			  if (!(contains(value))) return false;
			  SlowMap2.this.remove(SlowMap2.this.keys.get(SlowMap2.this.values.indexOf(value)));        
			  super.remove(value);  
			  return true;
		  }
		  @Override
		  public void clear() {
				 SlowMap2.this.clear();
				 super.clear();
			 } 
	  };
  }
  */
  public Set<Map.Entry<K,V>> entrySet() {
	   Set<Map.Entry<K,V>> set= new SlowEntrySet();
	    Iterator i = data.iterator();

	    while(i.hasNext())
	      set.add((Map.Entry<K,V>)i.next());
	    return set;
  }
  public static void main(String[] args) {
    SlowMap2<String,String> m= new SlowMap2<String,String>();
    m.putAll(Countries.capitals(5));
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
