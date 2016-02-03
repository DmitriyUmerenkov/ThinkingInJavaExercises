package generics.coffee;

public class Breve extends Coffee {
	
	public static class Factory implements generics.coffee.factory.Factory<Breve> {

		@Override
		public Breve create() {
return new Breve();		}
		
	}
}