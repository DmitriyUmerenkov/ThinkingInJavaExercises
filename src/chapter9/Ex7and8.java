package chapter9;

class Outer2 {
	private int i=1;
	private int getInt () {return i;}
	
	class Inner {
		private int i2=0;
		void modify(int i) {
			System.out.println("(Inner)Value of i= " + getInt()+" i2="+ i2);
			Outer2.this.i=i;
			
		}
	}	
		void useModify() {
			Outer2.Inner in = new Outer2.Inner();
			System.out.println("(1)(Outer)Value of i= " + getInt()+" i2=" + in.i2);

			in.i2++;
			in.modify(22);
			System.out.println("(2)(Outer)Value of i= " + getInt()+" i2=" + in.i2);
			
		}
		
		
}
	



public class Ex7and8 {

	static public void main (String[] Args) {
		Outer2 o=new Outer2();
	//	System.out.println("(External)Value of i= " + o.getInt());
		o.useModify();
	}
	
	
}
