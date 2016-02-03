package chapter6;
import debug.debugger;

class LocalDebugger extends debugger {
	void pprdebug() {prdebug();}
	
}


public class Ex15 {

	public static void main(String[] args) {
	
		LocalDebugger D = new LocalDebugger();
	D.pprdebug();	
		
	}
	
	
}
