package generics.coffee;

public class Cappuccino extends Coffee {
	public static class Factory implements generics.coffee.factory.Factory<Cappuccino> {

		@Override
		public Cappuccino create() {
return new Cappuccino();		}
		
	}
	
} ///:~
//: generics/coffee/Americano.java

