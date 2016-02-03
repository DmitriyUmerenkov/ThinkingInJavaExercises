package generics.coffee;

public class Latte extends Coffee {
	
	public static class Factory implements generics.coffee.factory.Factory<Latte> {

		@Override
		public Latte create() {
return new Latte();		}
		
	}
	
} ///:~
//: generics/coffee/Mocha.java
