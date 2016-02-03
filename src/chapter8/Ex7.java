package chapter8;

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

interface Rodent{
	
	void jump();
	void hide();
	
}

class Mouse implements Rodent{
	Characteristic subfamily= new Characteristic("Mousis");

	
	Mouse() {print("Creating mouse");}
	public void jump() {print("Mouse jump");}
	public void hide() {print("Mouse hide");}
}

class Herbil implements Rodent{
	Characteristic subfamily= new Characteristic("Rodentis");

	
	Herbil() {print("Creating herbil");}
	public void jump() {print("Herbil jump");}
	public void hide() {print("Herbil hide");}
}

class Hamster implements Rodent{
	Characteristic subfamily= new Characteristic("Hamsteris");

	
	Hamster() {print("Creating hamster");}
	public void jump() {print("Hamster jump");}
	public void hide() {print("Hamster hide");}
}



public class Ex7 {

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
