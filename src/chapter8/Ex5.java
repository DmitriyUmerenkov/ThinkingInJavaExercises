package chapter8;

import util.Separated;
import static util.Print.*;
class Joined implements Separated {
	
	public void a() {print("a()");}
	public void b() {print("b()");}
	public void c() {print("c()");}
	
	
}



public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Joined j = new Joined();
		j.a();
		j.b();
		j.c();
		
	}

}
