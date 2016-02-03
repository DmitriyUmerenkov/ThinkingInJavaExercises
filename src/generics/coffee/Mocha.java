package generics.coffee;

public class Mocha extends Coffee {
	
	public static class Factory implements generics.coffee.factory.Factory<Mocha> {

		@Override
		public Mocha create() {
return new Mocha();		}
		
	}

	
	
} ///:~
//: generics/coffee/Cappuccino.java
