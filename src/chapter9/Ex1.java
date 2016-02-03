package chapter9;


	class Outer {
		private String st;
		Outer(String st) {this.st=st;} 
		
		class Inner {
			
			
			public String toString() {return st;}
		}
		
		Inner getInner() {return new Inner();}
		
	}


public class Ex1 {

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Outer o = new Outer("Test String");
Outer.Inner i=o.getInner();
//Outer.Inner i2 =new Outer.Inner();
System.out.println(i.toString());
	}

}
