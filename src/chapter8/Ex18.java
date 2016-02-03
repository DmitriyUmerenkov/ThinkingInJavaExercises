package chapter8;

interface Cycle{
	
	void ride();
	int wheels();
	
}

interface CycleFactory{
	
	Cycle GetCycle ();
}

class Unicycle implements Cycle {

	public void ride() {System.out.println("Riding unicycle");};
	public int wheels() {return 1;}
	public void balance() {System.out.println("Balancing on wheels count " + wheels());}
	
}
class Bicycle implements Cycle {
	
	public void ride() {System.out.println("Riding bicycle");};
	public int wheels() {return 2;}
	void balance() {System.out.println("Balancing on wheels count " + wheels());}
}
class Tricycle implements Cycle {
	
	public void ride() {System.out.println("Riding tricycle");};
	public	int wheels() {return 3;}
	public void balance() {System.out.println("Balancing on wheels count " + wheels());}
	
}


class UniCycleShop implements CycleFactory {

	@Override
	public Cycle GetCycle() {
		return new Unicycle();
	}
	
	
}

class BiCycleShop implements CycleFactory {

	@Override
	public Cycle GetCycle() {
		return new Bicycle();
	}
	
	
}

class TriCycleShop implements CycleFactory {

	@Override
	public Cycle GetCycle() {
		return new Tricycle();
	}
	
	
}





public class Ex18 {

public static void GetAndRideCycle(CycleFactory c) {

	Cycle s =c.GetCycle();	
	s.ride();

}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetAndRideCycle(new UniCycleShop());
		GetAndRideCycle(new BiCycleShop());
		GetAndRideCycle(new TriCycleShop());

		
	}

}
