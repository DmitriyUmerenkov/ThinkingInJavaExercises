package annotations;

import java.util.*;
import atunit.*;
import util.*;
public class HashSetTest<T> extends HashSet<T>{
 // HashSet<String> testObject = new HashSet<String>() {{System.out.println("Creating new testObject");}};
  @Test void initialization() {
    assert this.isEmpty();
  }
  @Test void _contains() {
	  this.add((T)("one"));
    assert this.contains("one");
  }
  @Test void _remove() {
	  this.add((T)"one");
    this.remove("one");
    assert this.isEmpty();
    }
  public static void main(String[] args) throws Exception {
	   OSExecute.command( "cd bin");
	  OSExecute.command(
      "java atunit.AtUnit HashSetTest");
  }
}
