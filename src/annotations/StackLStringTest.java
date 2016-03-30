package annotations;

import atunit.*;
import util.*;

public class StackLStringTest
extends StackL<String> {
	@Test void _push() {
    push("one");
    assert testtop().equals("one");
    push("two");
    assert testtop().equals("two");
  }
  @Test void _pop() {
    push("one");
    push("two");
    assert pop().equals("two");
    assert pop().equals("one");
  }
  @Test void _top() {
    push("A");
    push("B");
    assert testtop().equals("B");
    assert testtop().equals("B");
  }
  public static void main(String[] args) throws Exception {
    OSExecute.command(
      "java net.mindview.atunit.AtUnit StackLStringTest");
  }
}