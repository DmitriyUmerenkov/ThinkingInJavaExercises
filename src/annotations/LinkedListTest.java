package annotations;

import java.util.*;
import atunit.*;
import util.*;

public class LinkedListTest {
	LinkedList<String> testObject = new LinkedList<String>() {{System.out.println("Creating new testObject");}};
  @Test void initialization() {
    assert testObject.isEmpty();
  }
  @Test void _contains() {
	  testObject.add("one");
    assert testObject.contains("one");
  }
  @Test void _remove() {
	  testObject.add("one");
	  testObject.remove("one");
    assert testObject.isEmpty();
    }
  public static void main(String[] args) throws Exception {
	   OSExecute.command( "cd bin");
	  OSExecute.command(
      "java atunit.AtUnit HashSetTest");
  }
}