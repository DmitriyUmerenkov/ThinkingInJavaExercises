package generics;

import generics.coffee.*;
import java.util.*;
import util.*;

public class Generators {

public static <T> Collection<T>
fill(Collection<T> coll, Generator<T> gen, int n) {
for(int i = 0; i < n; i++)
coll.add(gen.next());
return coll;
}

public static <T> List<T>
fill(List<T> coll, Generator<T> gen, int n) {
for(int i = 0; i < n; i++)
coll.add(gen.next());
return coll;
}

public static <T> LinkedList<T>
fill(LinkedList<T> coll, Generator<T> gen, int n) {
for(int i = 0; i < n; i++)
coll.add(gen.next());
return coll;
}


public static <T> Set<T>
fill(Set<T> coll, Generator<T> gen, int n) {
for(int i = 0; i < n; i++)
coll.add(gen.next());
return coll;
}

public static <T> Queue<T>
fill(Queue<T> coll, Generator<T> gen, int n) {
for(int i = 0; i < n; i++)
coll.add(gen.next());
return coll;
}





public static void main(String[] args) {

LinkedList<Coffee> coffee = fill(
new LinkedList<Coffee>(), new CoffeeGenerator1(), 4);
for(Coffee c : coffee)
System.out.println(c);

List<Coffee> coffee2 = fill(
new ArrayList<Coffee>(), new CoffeeGenerator1(), 4);
for(Coffee c : coffee2)
System.out.println(c);




Set<Integer> fnumbers = fill(
new HashSet<Integer>(), new Fibonacci(), 12);
for(int i : fnumbers)
System.out.print(i + ", ");
}
}