package containers;
import util.*;
import java.util.*;

enum CurrentList {Array, Linked;}


public class FastTraversalLinkedList<T> extends AbstractList<T> implements List<T>{
	LinkedList<T> lList = new LinkedList<T>();
	ArrayList<T> aList = new ArrayList<T>();
	CurrentList focus=CurrentList.Array;
	
	FastTraversalLinkedList() {super();}
	FastTraversalLinkedList(Collection<T> col) {super(); addAll(col);}
	
	@Override
	public
	void clear() {aList.clear();lList.clear();focus=CurrentList.Array;}
	
	
	void syncSwitch() {
		if (focus==CurrentList.Array) {
			lList.clear();
			lList.addAll(aList);
			focus=CurrentList.Linked;
			}
		else {
			aList.clear();
			aList.addAll(lList);
			focus=CurrentList.Array;
			}
		}
	
	@Override
	public boolean addAll(Collection<? extends T> col) {
		if(focus==CurrentList.Linked) syncSwitch();
		return aList.addAll(col);
	}
	
	
	@Override
	public T get(int index) {
		if(focus==CurrentList.Linked) syncSwitch();
		return aList.get(index);
	}

	@Override
	public boolean add(T value) {
		if(focus==CurrentList.Linked) return lList.add(value);
		else return aList.add(value);
	}

	@Override
	public void add(int index, T value) {
		if(focus==CurrentList.Array) syncSwitch();
		lList.add(index, value);
	}
	
	@Override
	public T remove(int index) {
		if(focus==CurrentList.Array) syncSwitch();
		return lList.remove(index);
	}
	
	@Override
	public
	ListIterator<T> iterator() {
		if(focus==CurrentList.Array) return aList.listIterator();
		else return lList.listIterator();
	}
	
	
	
	@Override
	public T set(int index, T value) {
		if(focus==CurrentList.Linked) syncSwitch();
		return aList.set(index, value);
	}

	
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		if(focus==CurrentList.Linked) return lList.size();
		else return aList.size();

	}
public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
