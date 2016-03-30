package generics;

interface IF {
	void a();
	void b();
	
}

class IFC implements IF {
	public void a() {}
	public void b(){}
	public void c(){}
	
	
}


public class Ex20 {
	<T extends IF> void  method(T arg) {
		arg.a();
		arg.b();
		System.out.println("Oink!");}
	
	public static void main (String[] Args) {
		IFC i = new IFC();
		
		new Ex20().method(i);
		
		
	}
	
}
