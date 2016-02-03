package chapter5;
import static util.Print.print;

import debugoff.debugger;

class AccessMod 
{
private String st1;
private void privateMethod() {print("Private method"); }

String st2;
void packageaccessMethod() {print("Package access method"); }

protected String st3;
protected void protectedMethod() {print("Protected method"); }

public String st4;
public void publicMethod() {print("Public method"); }


} 


public class Ex5 {

	
	public static void main(String[] args) {
		AccessMod md = new AccessMod();
		
		print(md.st2);
		
	//	md.st1 ="a";
		md.st2 ="a";
		md.st3 ="a";
		md.st4 ="a";
				
		md.packageaccessMethod();
		md.protectedMethod();
		md.publicMethod();
		//md.privateMethod();
		
		
}
	
	
}
