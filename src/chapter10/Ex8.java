package chapter10;
import java.util.*;



public class Ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Gerbil> Farm = new ArrayList<Gerbil>();
		for (int i=0;i<10;i++) Farm.add(new Gerbil());
		
		Iterator<Gerbil> it=Farm.listIterator(0);

		while (it.hasNext())
			it.next().hop();

	}

}

