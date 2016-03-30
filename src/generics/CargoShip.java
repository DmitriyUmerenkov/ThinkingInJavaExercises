package generics;

import java.util.*;
import util.*;

class Crate {
	private static int counter=0;
	private final int id;
	private String Contents;
	private double Value;
	public Crate(String Contents, double Value) {
		id=counter++;
		this.Contents=Contents;
		this.Value=Value;
	}	
	public String toString() {
		return id+ ": "+ Contents+ " " + Value + "$";
	}
	public void priceChange (double Change)
	{
		Value+=Change;
	}

	public static Generator<Crate> generator = 
		new Generator<Crate>(){
		Random rand= new Random();
		@Override
		public Crate next() {
			return new Crate("Test Crate", rand.nextInt(1000)+(double)(rand.nextInt(100))/100);
		}};		
}
	
class Hold extends ArrayList<Crate>{

	public Hold(int CrateNum) {
	for (int i=0;i<CrateNum;i++) add(Crate.generator.next());
    }	
}
	
class Deck extends ArrayList<Hold>{
	public Deck(int HoldNum, int CrateNum) {
	for (int i=0;i<HoldNum;i++) add(new Hold(CrateNum));
 }	
}
	
class Hull {}

class Bridge {}

public class CargoShip {

	String name;
	Hull aHull;
	Bridge aBridge;
	ArrayList<Deck> decks = new ArrayList<Deck>();
	CargoShip (String name, int DeckNum, int HoldNum, int CrateNum)
	{
		this.name=name;
		for (int i=0;i<DeckNum;i++) decks.add(new Deck(HoldNum, CrateNum));
	aHull=new Hull();
	aBridge=new Bridge();
	}
	
	void report() {
		for (Deck d: decks)
			for (Hold h: d)
				for (Crate c: h)
					System.out.println(c);
		
		
	}
	
	

	public static void main (String[] Args) {
		CargoShip Victoria = new CargoShip ("Victoria",3,4,5);
		Victoria.report();
		
	}
	
}
