package exceptions;

class VeryImportantException extends Exception {
	 public String toString() {
	 return "A very important exception!";
	 }
	}
	class HoHumException extends Exception {
	 public String toString() {
	 return "A trivial exception";
	 }
	}
	class TumBumException extends Exception{
		public String toString() {
		return "Even more trivial exception";
		}
		
	}
	
	public class LostMessage {
	 void f() throws VeryImportantException {
	 throw new VeryImportantException();
	 }
	 void dispose() throws HoHumException {
	 throw new HoHumException();
	 }
	 void trivia() throws TumBumException {
		 throw new TumBumException();
	 }
	 public static void main(String[] args) {
		 
		 LostMessage lm = new LostMessage();
	 
	 try {
	     try {
	         try {
	             lm.f();
	             } 
	     finally {
	           try {
	    	 	lm.dispose();
	           }  
	           catch (Exception e) {}
	           }
	          }
	          finally	          {
		     // lm.trivia();
	          }
	 
		 }
     catch(Exception e) 
     {
     System.out.println(e);
     }
	 
	 }
	} 