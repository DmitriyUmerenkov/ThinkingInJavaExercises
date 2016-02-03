package generics.coffee;

public class StoryCharacter {

	private static long counter = 0;
	private final long id = counter++;
	public String toString() {
	return getClass().getSimpleName() + " " + id;
	}	
	
	
}

class GoodGuy extends StoryCharacter {
	
}

class BadGuy extends StoryCharacter {
	
}

class Orc extends BadGuy {
	
}

class Ogre extends BadGuy {
	
}

class Goblin extends BadGuy {
	
}

class Elf extends GoodGuy {
	
}

class Dwarf extends GoodGuy {
		
}

class Hobbit extends GoodGuy{
	
}