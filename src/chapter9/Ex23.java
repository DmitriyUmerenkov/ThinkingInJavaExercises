package chapter9;

interface U {
	void a();
	void b();
	void c();
	
}

class A {
	U getUref() {return new U(){
		public void a(){System.out.println("Calling a() for" + this);}
		public void b(){System.out.println("Calling b() for" + this);}
		public void c(){System.out.println("Calling c() for" + this);}
		};}
}

class B {
	U[] Storage = new U[3];
	void store(U stuff, int i) {
		Storage[i]=stuff;
	}
	void erase(int i) {Storage[i]=null;}
	void cycle() {
		for (int i=0;i<Storage.length;i++) {
			Storage[i].a();
			Storage[i].b();
			Storage[i].c();
		}
	}
}


public class Ex23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
B aB =new B();
A[] anA =new A[3];
for (int i=0;i<3;i++) {
	anA[i]= new A();
	aB.store(anA[i].getUref(), i);
	
}
aB.cycle();
aB.erase(1);
aB.cycle();



	}

}
