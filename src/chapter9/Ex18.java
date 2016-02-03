package chapter9;








public class Ex18 {
	private static class InnerStatic{
		int i;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
InnerStatic is = new InnerStatic();
InnerStatic isw = new InnerStatic();
	is.i=10;
	isw.i=20;
	System.out.println(is.i+ " " +isw.i);
	}

}
