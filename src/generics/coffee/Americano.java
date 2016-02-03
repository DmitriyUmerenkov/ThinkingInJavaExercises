package generics.coffee;

public class Americano extends Coffee {
	
	public static class Factory implements generics.coffee.factory.Factory<Americano> {

		@Override
		public Americano create() {
return new Americano();		}
		
	}
	
} ///:~
//: generics/coffee/Breve.java
