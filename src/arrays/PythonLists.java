package arrays;
import java.util.*;

class MyList extends ArrayList<Integer> {
	MyList(ArrayList<Integer> l) {super(l);}
	MyList() {};
	public MyList getReversed() {
		ArrayList<Integer> result = new ArrayList<Integer>((ArrayList<Integer>)this);
		Collections.reverse(result);
		return new MyList(result);
	}
	public String toString() {return this.getClass().toString()+super.toString();}
}

public class PythonLists {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> aList=new ArrayList<Integer>(Arrays.asList(new Integer[] {1,2,3,4,5}));
		System.out.println(aList);
		System.out.println(aList.get(4));
		aList.add((Integer)6);
		aList.addAll(Arrays.asList(new Integer[]{7,8}));
		System.out.println(aList);
		List<Integer> aSubList = aList.subList(2, 4);
		System.out.println(aSubList);
		
		MyList aList2=new MyList((ArrayList<Integer>)aList);
		System.out.println(aList2);
		System.out.println(aList2.getReversed());
	}

}

/*

aList = [1, 2, 3, 4, 5]
print type(aList) # <type ‘list’>
print aList # [1, 2, 3, 4, 5]
print aList[4] # 5 Basic list indexing
aList.append(6) # lists can be resized
aList += [7, 8] # Add a list to a list
print aList # [1, 2, 3, 4, 5, 6, 7, 8]
aSlice = aList[2:4]
print aSlice # [3, 4]
class MyList(list): # Inherit from list
    # Define a method, ‘this’ pointer is explicit:
    def getReversed(self):
        reversed = self[:] # Copy list using slices
        reversed.reverse() # Built-in list method
        return reversed

￼list2 = MyList(aList) # No ‘new’ needed for object creation
print type(list2) # <class ‘__main__.MyList’>
print list2.getReversed() # [8, 7, 6, 5, 4, 3, 2, 1]


*/