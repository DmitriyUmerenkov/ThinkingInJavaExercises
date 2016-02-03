package chapter9;

class Outer3 {
	
	private class Inner implements util.Separated {

		@Override
		public void a() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void b() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void c() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	util.Separated getSeparated() {
		
		return new Inner();
		
	}
	
}

public class Ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Outer3 o = new Outer3();
util.Separated s = o.getSeparated();
	
	}

}
