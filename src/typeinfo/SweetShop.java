package typeinfo;

import static util.Print.*;

import java.util.Arrays;
class Candy {
 static { print("Loading Candy"); }
}
class Gum {
 static { print("Loading Gum"); }
}
class Cookie {
 static { print("Loading Cookie"); }
}

public class SweetShop {
 public static void main(String[] args) {
 print("inside main");
 
 if (Arrays.asList(args).contains("Candy"))

	 {
	 new Candy();
	 print("After creating Candy");

	 }

 if (Arrays.asList(args).contains("Cookie"))

 {
	 new Cookie();
	 print("After creating Cookie");

 }
 if (Arrays.asList(args).contains("Gum"))

 {
 new Gum();
 print("After creating Gum");

 }

 /*
 try {
 Class.forName("typeinfo.Gum");
 } catch(ClassNotFoundException e) {
 print("Couldn’t find Gum");
 }
 print("After Class.forName(\"Gum\")");
 */
 }
} 
 