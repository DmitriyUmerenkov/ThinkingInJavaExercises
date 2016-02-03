package chapter7;
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




public class Ex9and12and13 {

	public static void main(String[] args) {
		Rodent[] r =new Rodent[5];
		Random rand = new Random();
		
		for (int i=0;i<5;i++)
			switch(rand.nextInt(3)) {
			case 0: r[i]=new Mouse(); break;
			case 1: r[i]=new Herbil(); break;
			case 2: r[i]=new Hamster(); break;
			}
		
		for (int i=0;i<5;i++) {
			r[i].jump();
			r[i].hide();
			
		}
			
		
		
		// TODO Auto-generated method stub

	}

}
