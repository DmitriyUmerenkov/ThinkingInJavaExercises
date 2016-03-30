package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;
import static util.Print.*;
public class ReaderWriterMap<K,V>  extends AbstractMap<K,V>{

	public ReaderWriterMap(Map<? extends K,? extends V> m)
	{
		lockedMap=new HashMap(m);
	}
	
	
	private HashMap<K,V> lockedMap;
  // Make the ordering fair:
  private ReentrantReadWriteLock lock =
    new ReentrantReadWriteLock(true);
  public ReaderWriterMap() {
    lockedMap = new HashMap<K,V>();
  }
 
  public V put(K key, V value) {
    Lock wlock = lock.writeLock();
    wlock.lock();
    try {
      return lockedMap.put(key, value);
    } finally {
      wlock.unlock();
    }
  }
  @Override
  public V get(Object key) {
    Lock rlock = lock.readLock();
    rlock.lock();
    try {
      // Show that multiple readers
      // may acquire the read lock:
     // if(lock.getReadLockCount() > 1)
     //   print(lock.getReadLockCount());
      return lockedMap.get(key);
    } finally {
      rlock.unlock();
} }



@Override
public Set<java.util.Map.Entry<K, V>> entrySet() {
	// TODO Auto-generated method stub
	return null;
}
 
} 
