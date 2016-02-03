package generics.coffee;
import java.util.Iterator;
import java.util.*;

import util.Generator;

public class TolkienCharacterGenerator 
implements Generator<StoryCharacter>, Iterable<StoryCharacter>  {
	int Count;
	Random r=new Random();
	TolkienCharacterGenerator(int Count) {	this.Count=Count;	}

	private Class<?/* extends StoryCharacter*/> Types[] = {Orc.class, Ogre.class, Goblin.class, Elf.class, Dwarf.class, Hobbit.class}; 

	private StoryCharacter getRandom() {
		try{
		 return (StoryCharacter)Types[r.nextInt(Types.length)].newInstance();
		}
		catch(Exception e) {
			System.out.println(e); 
			throw new RuntimeException(e);} 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TolkienCharacterGenerator LOR = new TolkienCharacterGenerator(10);
		System.out.println(LOR.next());
		System.out.println(LOR.next());
		System.out.println(LOR.next());
		
		System.out.println();
		
		
		for (StoryCharacter st: new TolkienCharacterGenerator(10))
			System.out.println(st);
		
		
	}

	@Override
	public Iterator<StoryCharacter> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<StoryCharacter>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return (Count>0);
			}

			@Override
			public StoryCharacter next() {
				// TODO Auto-generated method stub
				Count--;
				return getRandom();
			}
		};
	}

	@Override
	public StoryCharacter next() {
		// TODO Auto-generated method stub
		return getRandom();
	}

}
