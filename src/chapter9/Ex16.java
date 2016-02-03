package chapter9;


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
	public static CycleFactory shop = new CycleFactory(){

		@Override
		public Cycle GetCycle() {
			return new Unicycle();
		}		
	};
	
}
class Bicycle implements Cycle {
	
	public void ride() {System.out.println("Riding bicycle");};
	public int wheels() {return 2;}
	void balance() {System.out.println("Balancing on wheels count " + wheels());}
	public static CycleFactory shop = new CycleFactory(){
		@Override
		public Cycle GetCycle() {
			return new Bicycle();
		}	
	};
}
class Tricycle implements Cycle {
	
	public void ride() {System.out.println("Riding tricycle");};
	public	int wheels() {return 3;}
	public void balance() {System.out.println("Balancing on wheels count " + wheels());}
	public static CycleFactory shop = new CycleFactory() {
		@Override
		public Cycle GetCycle() {
			return new Tricycle();
		}
	};
}


public class Ex16 {

public static void GetAndRideCycle(CycleFactory c) {

	Cycle s =c.GetCycle();	
	s.ride();

}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetAndRideCycle(Unicycle.shop);
		GetAndRideCycle(Bicycle.shop);
		GetAndRideCycle(Tricycle.shop);

		
	}

}
