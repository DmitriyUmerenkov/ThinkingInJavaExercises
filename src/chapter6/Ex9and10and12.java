package chapter6;

class Component1 {
	Component1(int i){System.out.println("Component1 constructor");}
	
void dispose() {System.out.println("Component1 disposal");}  
}


class Component2 {
	Component2(int i){System.out.println("Component2 constructor");}
	void dispose() {System.out.println("Component2 disposal");}  

}


class Component3 {
	Component3(int i){System.out.println("Component3 constructor");}
	void dispose() {System.out.println("Component3 disposal");}  

}




class Root {
	Component1 c1;
	Component2 c2;
	Component3 c3;
	
	Root(int i) {
		System.out.println("Root constructor");
		c1 = new Component1(i);
		c2 = new Component2(i);
		c3 = new Component3(i);
		
	
	}	
	void dispose() {
		c3.dispose();
		c2.dispose();
		c1.dispose();
		
		System.out.println("Root disposal");
		}  



}

class Stem extends Root{
	Component1 c1;
	Component2 c2;
	Component3 c3;
	
	Stem(int i) {
		super(i);
		c1 = new Component1(i);
		c2 = new Component2(i);
		c3 = new Component3(i);
		
		
		System.out.println("Stem constructor");
		}
	
	void dispose() {
		c3.dispose();
		c2.dispose();
		c1.dispose();
		
		System.out.println("Stem disposal");		
		super.dispose();	
	}  

	
}


public class Ex9and10and12 {

	public static void main(String[] args) {
Stem st =new Stem(111);
st.dispose();
	}

}
