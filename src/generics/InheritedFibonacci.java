package generics;


import java.util.*;
public class InheritedFibonacci
implements Iterable<Integer> {
private int n;
private Fibonacci Sequence;

public InheritedFibonacci(int count) { n = count; Sequence = new Fibonacci();}

public Iterator<Integer> iterator() {
return new Iterator<Integer>() {
public boolean hasNext() { return n > 0; }
public Integer next() {
n--;
return Sequence.next();
}
public void remove() { // Not implemented
throw new UnsupportedOperationException();
}
};
}

public static void main(String[] args) {
for(int i : new InheritedFibonacci(18))
System.out.print(i + " ");
}
}