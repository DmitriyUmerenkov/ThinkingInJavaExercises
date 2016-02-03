package chapter6;
import static util.Print.print;

class Amphibian {

	void swim (int direction) {print("Amphibian swimming");};
	void crawl (int direction) {print("Amphibian crawling");};
	void eat() {print("Amphibian eating");}
}

class Frog extends Amphibian {

	void swim (int direction) {print("Frog swimming");};
	void crawl (int direction) {print("Frog crawling");};
	void eat() {print("Frog eating");}

	
}


public class Ex16and17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Frog Jean = new Frog(); 
		Jean.swim(0);
		Jean.crawl(0);
		Jean.eat();
		
	}

}
