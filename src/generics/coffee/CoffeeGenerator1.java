package generics.coffee;

import java.util.*;


import generics.coffee.factory.*;
import util.*;

public class CoffeeGenerator1
implements Generator<Coffee>, Iterable<Coffee> {

	private Class[] types = { Latte.class, Mocha.class,
Cappuccino.class, Americano.class, Breve.class, };

	static List<Factory<? extends Coffee>> CoffeeFactories =
			new ArrayList<Factory<? extends Coffee>>();

			static {
			// Collections.addAll() gives an "unchecked generic
			// array creation ... for varargs parameter" warning.
				CoffeeFactories.add(new Americano.Factory());
				CoffeeFactories.add(new Breve.Factory());
				CoffeeFactories.add(new Cappuccino.Factory());
				CoffeeFactories.add(new Latte.Factory());
				CoffeeFactories.add(new Mocha.Factory());
			}

	
	
	
	
	private static Random rand = new Random(47);

	public CoffeeGenerator1() {}
// For iteration:
private int size = 0;
public CoffeeGenerator1(int sz) { size = sz; }

@Override
public Coffee next() {
/*try {
return (Coffee)
types[rand.nextInt(types.length)].newInstance();
// Report programmer errors at run time:
} catch(Exception e) {
throw new RuntimeException(e);
}*/

return CoffeeFactories.get(rand.nextInt(CoffeeFactories.size())).create();

}
class CoffeeIterator implements Iterator<Coffee> {
int count = size;
@Override
public boolean hasNext() { return count > 0; }
@Override
public Coffee next() {
count--;
return CoffeeGenerator1.this.next();
}
@Override
public void remove() { // Not implemented
throw new UnsupportedOperationException();
}
};
@Override
public Iterator<Coffee> iterator() {
return new CoffeeIterator();
}
public static void main(String[] args) {

	TypeCounter counter = new TypeCounter(Coffee.class);

	
CoffeeGenerator1 gen = new CoffeeGenerator1();
Coffee CurrentCup;
for(int i = 0; i < 5; i++)
{
	CurrentCup=gen.next();
	System.out.println(CurrentCup);
	counter.count(CurrentCup);
	

}
for(Coffee c : new CoffeeGenerator1(5))
{
	System.out.println(c);
	counter.count(c);
}

System.out.println(counter.toString());

}
}