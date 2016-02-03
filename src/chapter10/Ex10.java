package chapter10;

import static util.Print.*;
import java.util.*;

class Characteristic {
	 private String s;
	 Characteristic(String s) {
	 this.s = s;
	 print("Creating Characteristic " + s);
	 }
	 protected void dispose() {
	 print("disposing Characteristic " + s);
	 }
	} 

class Rodent{
	Characteristic family= new Characteristic("Rodentus");
	
	Rodent() {print("Creating rodent");}
	void jump() {print("Rodent jump");}
	void hide() {print("Rodent hide");}
	
}

class Mouse extends Rodent{
	Characteristic subfamily= new Characteristic("Mousis");

	
	Mouse() {print("Creating mouse");}
	void jump() {print("Mouse jump");}
	void hide() {print("Mouse hide");}
}

class Herbil extends Rodent{
	Characteristic subfamily= new Characteristic("Rodentis");

	
	Herbil() {print("Creating herbil");}
	void jump() {print("Herbil jump");}
	void hide() {print("Herbil hide");}
}

class Hamster extends Rodent{
	Characteristic subfamily= new Characteristic("Hamsteris");

	
	Hamster() {print("Creating hamster");}
	void jump() {print("Hamster jump");}
	void hide() {print("Hamster hide");}
}




public class Ex10 {

	public static void main(String[] args) {
		ArrayList<Rodent> r =new ArrayList<Rodent>();
		Random rand = new Random();
		
		for (int i=0;i<5;i++)
			switch(rand.nextInt(3)) {
			case 0: r.add(new Mouse()); break;
			case 1: r.add(new Herbil()); break;
			case 2: r.add(new Hamster()); break;
			}
		
		Iterator<Rodent> it= r.iterator();
		Rodent rod;
	while (it.hasNext()) {
		rod=it.next();
		rod.jump();
		rod.hide();
			}
			
		
		
		// TODO Auto-generated method stub

	}

}
