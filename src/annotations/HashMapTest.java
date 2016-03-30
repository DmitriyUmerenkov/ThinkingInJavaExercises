package annotations;

import java.util.*;
import atunit.*;


public class HashMapTest extends HashMap<Integer,String>{

	@Test boolean _put () {
		this.put(1, "one");
		return this.get(1).equals("one");
    	}
	
	@Test boolean _size () {
		this.put(1, "one");
		return (this.size()==1);
    	}
    @Test boolean _clear() {
	    this.put(1, "one");
	    this.put(2, "two");
        this.clear();
        return this.isEmpty();
        }
    
    @TestNote("Just note") void m1(){System.out.println("This sHOULD NOT be Printed!");};
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
