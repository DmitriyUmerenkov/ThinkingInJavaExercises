package pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


import typeinfo.factory.Factory;

public class FactoryPetCreator extends PetCreator {

	private Random rand = new Random(47);

	@Override
	public List<Class<? extends Pet>> types() {
		// TODO Auto-generated method stub
		return null;
	}
	

	static List<Factory<? extends Pet>> petFactories =
			new ArrayList<Factory<? extends Pet>>();

			static {
			// Collections.addAll() gives an "unchecked generic
			// array creation ... for varargs parameter" warning.
			petFactories.add(new Mutt.Factory());
			petFactories.add(new Pug.Factory());
			petFactories.add(new EgyptianMau.Factory());
			petFactories.add(new Manx.Factory());
			petFactories.add(new Cymric.Factory());
			petFactories.add(new Rat.Factory());
			petFactories.add(new Mouse.Factory());
			petFactories.add(new Hamster.Factory());
			petFactories.add(new Gerbil.Factory());
			}

				
	 public Pet randomPet() { // Create one random Pet
		 return petFactories.get(rand.nextInt(petFactories.size())).create();
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
