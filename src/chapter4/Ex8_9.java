package chapter4;


class Cup {

	Cup() {System.out.println("Empty cup");}
	Cup(int i) {this(); System.out.println("Integer cup "+ i); } 
	
	void lift () { System.out.println("Lifting");}
	
	void drink() {
		lift();
		this.lift();
		
	}
	
	
	
	
}


public class Ex8_9 {

	public static void main(String[] args) {
Cup aCup = new Cup(5);
aCup.drink();

	}

}
