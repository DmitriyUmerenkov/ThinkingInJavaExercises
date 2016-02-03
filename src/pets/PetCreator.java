package pets;

import java.util.*;
import typeinfo.factory.*;


class Individual {
	public Individual() {};
	public Individual(String name) {};
}

class Person extends Individual {
public Person(String name) { super(name); }
} ///:~
//: typeinfo/pets/Pet.java

class Pet extends Individual {
public Pet(String name) { super(name); }
public Pet() { super(); }
} ///:~
//: typeinfo/pets/Dog.java
class Dog extends Pet {
public Dog(String name) { super(name); }
public Dog() { super(); }
} ///:~
//: typeinfo/pets/Mutt.java
class Mutt extends Dog {
public Mutt(String name) { super(name); }
public Mutt() { super(); }
public static class Factory implements typeinfo.factory.Factory<Mutt> {

	@Override
	public Mutt create() {
		// TODO Auto-generated method stub
		return new Mutt();
	}
	
	
}
} ///:~
//: typeinfo/pets/Pug.java
class Pug extends Dog {
public Pug(String name) { super(name); }
public Pug() { super(); }

public static class Factory implements typeinfo.factory.Factory<Pug> {
	@Override
	public Pug create() {
		// TODO Auto-generated method stub
		return new Pug();}
	}
} ///:~
//: typeinfo/pets/Cat.java
class Cat extends Pet {
public Cat(String name) { super(name); }
public Cat() { super(); }
} ///:~
//: typeinfo/pets/EgyptianMau.java
class EgyptianMau extends Cat {
public EgyptianMau(String name) { super(name); }
public EgyptianMau() { super(); }
public static class Factory implements typeinfo.factory.Factory<EgyptianMau> {
	@Override
	public EgyptianMau create() {
		// TODO Auto-generated method stub
		return new EgyptianMau();}
	}
} ///:~
//: typeinfo/pets/Manx.java
class Manx extends Cat {
public Manx(String name) { super(name); }
public Manx() { super(); }
public static class Factory implements typeinfo.factory.Factory<Manx> {
	@Override
	public Manx create() {
		// TODO Auto-generated method stub
		return new Manx();}
	}
} ///:~
//: typeinfo/pets/Cymric.java
class Cymric extends Manx {
public Cymric(String name) { super(name); }
public Cymric() { super(); }
public static class Factory implements typeinfo.factory.Factory<Cymric> {
	@Override
	public Cymric create() {
		// TODO Auto-generated method stub
		return new Cymric();}
	}
} ///:~
//: typeinfo/pets/Rodent.java
class Rodent extends Pet {
public Rodent(String name) { super(name); }
public Rodent() { super(); }
} ///:~
//: typeinfo/pets/Rat.java
class Rat extends Rodent {
public Rat(String name) { super(name); }
public Rat() { super(); }
public static class Factory implements typeinfo.factory.Factory<Rat> {
	@Override
	public Rat create() {
		// TODO Auto-generated method stub
		return new Rat();}
	}

} ///:~
//: typeinfo/pets/Mouse.java
class Mouse extends Rodent {
public Mouse(String name) { super(name); }
public Mouse() { super(); }
public static class Factory implements typeinfo.factory.Factory<Mouse> {
	@Override
	public Mouse create() {
		// TODO Auto-generated method stub
		return new Mouse();}
	}

} ///:~
//: typeinfo/pets/Hamster.java
class Hamster extends Rodent {
public Hamster(String name) { super(name); }
public Hamster() { super(); }
public static class Factory implements typeinfo.factory.Factory<Hamster> {
	@Override
	public Hamster create() {
		// TODO Auto-generated method stub
		return new Hamster();}
	}

}
class Gerbil extends Rodent {
public Gerbil(String name) { super(name);} 
public Gerbil() {super();}	
public static class Factory implements typeinfo.factory.Factory<Gerbil> {
	@Override
	public Gerbil create() {
		// TODO Auto-generated method stub
		return new Gerbil();}
	}

}

public abstract class PetCreator {
	 private Random rand = new Random(47);
	 // The List of the different types of Pet to create:
	 public abstract List<Class<? extends Pet>> types();
	 public Pet randomPet() { // Create one random Pet
	 int n = rand.nextInt(types().size());
	 try {
	 return types().get(n).newInstance();
	 } catch(InstantiationException e) {
	 throw new RuntimeException(e);
	 } catch(IllegalAccessException e) {
	 throw new RuntimeException(e);
	 }
	 }
	 public Pet[] createArray(int size) {
	 Pet[] result = new Pet[size];
	 for(int i = 0; i < size; i++)
	 result[i] = randomPet();
	 return result;
	 }
	 public ArrayList<Pet> arrayList(int size) {
	 ArrayList<Pet> result = new ArrayList<Pet>();
	 Collections.addAll(result, createArray(size));
	 return result;
	 }
	} 