package exceptions;
import java.util.logging.*;
import java.io.*;

class Exception1 extends Exception {
private static Logger logger = Logger.getLogger("Exception1");
	public Exception1() {
		StringWriter trace= new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
	
}


class Exception2 extends Exception {
	private static Logger logger = Logger.getLogger("Exception2");
	public Exception2() {
		StringWriter trace= new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
	
}



public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			throw new Exception1();
		}
		catch (Exception e) {
			
		}

		try {
			throw new Exception2();
		}
		catch (Exception e) {
			
		}

		
	}

}
