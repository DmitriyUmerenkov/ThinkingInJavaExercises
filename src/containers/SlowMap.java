package containers;

import java.util.*;
import util.*;

public class SlowMap<K,V> extends AbstractMap<K,V> implements Map<K,V>{
  private List<K> keys = new ArrayList<K>();
  private List<V> values = new ArrayList<V>();
  public V put(K key, V value) {
    V oldValue = get(key); // The old value or null
    if(!keys.contains(key)) {
      keys.add(key);
      values.add(value);
    } else
      values.set(keys.indexOf(key), value);
    return oldValue;
  }
  public V get(Object key) { // key is type Object, not K
    if(!keys.contains(key))
      return null;
    return values.get(keys.indexOf(key));
  }

  @Override
  public V remove(Object key) {
		if (keys.contains(key))
	{
		int index=keys.indexOf(key);
		keys.remove(index);
		return values.remove(index);
	}
	  return null;
  }
  
  public void clear() {
	  keys.clear();
	  values.clear();
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
			return new MapEntry(SlowMap.this.keys.get(position-1),SlowMap.this.values.get(position-1));
		}
		@Override
		public void remove(){
			SlowEntrySet.this.remove(new MapEntry(SlowMap.this.keys.get(position-1),SlowMap.this.values.get(position-1)));
			position--;
		}	    
	  }
	  @Override 
		public Iterator<Map.Entry<K, V>> iterator() {return new Iter();}
	  
	  
	  @Override
	  public boolean remove(Object o) {
		if (!contains(o)) return false;
		else {
			SlowMap.this.remove(((Map.Entry<K,V>)o).getKey());
			return super.remove(o);
		}
	}
	 
	 @Override
	  public void clear() {
		 SlowMap.this.clear();
		 super.clear();
	 } 
	
}
  
  
  public Set<K> keySet() {
	
	  return new HashSet<K>() {
		  {
			  for (Map.Entry<K, V> en: SlowMap.this.entrySet())
				  this.add(en.getKey());			  
		  }
		  
		  
		  class Iter implements Iterator<K> {
			  int position;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				if (position<SlowMap.this.entrySet().size()) return true;
				return false;
			}

			@Override
			public K next() {
				// TODO Auto-generated method stub
				position++;
				return SlowMap.this.keys.get(position-1);
			}
			@Override
			public void remove(){
				SlowMap.this.keySet().remove(SlowMap.this.keys.get(position-1));		
				position--;
			}	    
		  }
		  @Override 
			public Iterator<K> iterator() {return new Iter();
			}
		  
		  
		  
		  @Override
		  public boolean remove (Object key) {
			  if (!(contains(key))) return false;
			  SlowMap.this.remove(key);
			  super.remove(key);  
			  return true;
		  }
		  @Override
		  public void clear() {
				 SlowMap.this.clear();
				 super.clear();
			 } 
	  };
  }
  
  
  public Collection<V> Values() {
		
	  return new ArrayList<V>() {
		  {
			  this.addAll(SlowMap.this.values);
		   }
		  
		  
		  class Iter implements Iterator<V> {
			  int position;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				if (position<SlowMap.this.values.size()) return true;
				return false;
			}

			@Override
			public V next() {
				// TODO Auto-generated method stub
				position++;
				return SlowMap.this.values.get(position-1);
			}
			@Override
			public void remove(){
				SlowMap.this.Values().remove(SlowMap.this.values.get(position-1));		
				position--;
			}	    
		  }
		  @Override 
			public Iterator<V> iterator() {return new Iter();
			}
		  
		  
		  
		  @Override
		  public boolean remove (Object value) {
			  if (!(contains(value))) return false;
			  SlowMap.this.remove(SlowMap.this.keys.get(SlowMap.this.values.indexOf(value)));        
			  super.remove(value);  
			  return true;
		  }
		  @Override
		  public void clear() {
				 SlowMap.this.clear();
				 super.clear();
			 } 
	  };
  }
  
  public Set<Map.Entry<K,V>> entrySet() {
    Set<Map.Entry<K,V>> set= new SlowEntrySet();
    Iterator<K> ki = keys.iterator();
    Iterator<V> vi = values.iterator();
    while(ki.hasNext())
      set.add(new MapEntry<K,V>(ki.next(), vi.next()));
    return set;
  }
  public static void main(String[] args) {
    SlowMap<String,String> m= new SlowMap<String,String>();
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