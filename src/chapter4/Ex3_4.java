package chapter4;

class Example
{
Example () {
	System.out.println("Creating Example");
}
Example (String st) {
	System.out.println("Creating Example "+ st);
}

}

public class Ex3_4 {

	public static void main(String[] args) {
	Example Ex= new Example();
	Example Ex2= new Example("with a string");
	}

}
