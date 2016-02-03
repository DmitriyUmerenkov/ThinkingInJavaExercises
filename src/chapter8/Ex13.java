package chapter8;

interface Base1 {
	void basemethod();
	}

interface Child1 extends Base1 {
	void child1method();
}

interface Child2 extends Base1 {
	void child2method();
}

interface Granchild extends Child1,Child2
{
	
}


public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
