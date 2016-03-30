package annotations;

import java.util.*;
import atunit.*;

public class StackL<T> {
  private LinkedList<T> list = new LinkedList<T>();
  public void push(T v) { list.addFirst(v); }
  private T top() { return list.getFirst(); }
  @TestProperty public T testtop() {return top();}
  public T pop() { return list.removeFirst(); }
} 