package util;

public class TwoTuple<A,B> implements Comparable<TwoTuple<A,B>>{

  public final A first;
  public final B second;
  
  public TwoTuple(A a, B b) { first = a; second = b; }


  public String toString() {
    return "(" + first + ", " + second + ")";
  }

  public boolean equals(Object o) {
	  return o!=null && first.equals(((TwoTuple<A,B>)o).first) && second.equals(((TwoTuple<A,B>)o).second);
	  }
  
  public int hashCode() {
	  int result=17;
	  result=result*37+first.hashCode();
	  result=result*37+second.hashCode();
	  return result;
  }

@Override
public int compareTo(TwoTuple<A, B> o) {
	// TODO Auto-generated method stub
	if (first instanceof Comparable && second instanceof Comparable) 
	{
		if (((Comparable)first).compareTo(second)!=0) return ((Comparable)first).compareTo(first);
		else return ((Comparable)second).compareTo(second);
	}
	else throw new RuntimeException("Uncomparable types in tuple");
}

}