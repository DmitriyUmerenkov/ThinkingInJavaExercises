package typeinfo;

import static util.Print.*;
import java.util.*;

class Shape {
 public boolean Highlighted=false;	
 public void draw() {}
 public void erase() {}
 public void rotate() {
	 if (this instanceof Circle) return;
	 else print("Shape.rotate()");
	 
 }
 public String toString() {return "This shape is highlited="+Highlighted;}
} ///:~
//: polymorphism/shape/Circle.java


class Circle extends Shape {

 public void draw() { print("Circle.draw()"); }
 public void erase() { print("Circle.erase()"); }
} ///:~

class Square extends Shape {
 public void draw() { print("Square.draw()"); }
 public void erase() { print("Square.erase()"); }
} ///:~

class Triangle extends Shape {
 public void draw() { print("Triangle.draw()"); }
 public void erase() { print("Triangle.erase()"); }
} ///:~

class Rhomboid extends Shape {
	 public void draw() { print("Triangle.draw()"); }
	 public void erase() { print("Triangle.erase()"); }
	} ///:~


// A "factory" that randomly creates shapes.
 class RandomShapeGenerator {
 private Random rand = new Random(47);
 public Shape next() {
 switch(rand.nextInt(3)) {
 default:
 case 0: return new Circle();
 case 1: return new Square();
 case 2: return new Triangle();
 }
 }
} ///:~
//: polymorphism/Shapes.java
// Polymorphism in Java.

 public class Shapes {
 private static RandomShapeGenerator gen =
 new RandomShapeGenerator();

 public static void highlightShape (Shape[] col, String ShapeType) {
	 for (Shape c: col)
	 {
/*		print(c.getClass().getSimpleName());
		print(ShapeType);
		String s1=c.getClass().getSimpleName();*/
		if (c.getClass().getSimpleName().equals(ShapeType))
			 c.Highlighted=true;
	 }
	 
 }
 
 
 public static void main(String[] args) {
 Shape[] s = new Shape[9];
 // Fill up the array with shapes:
 for(int i = 0; i < s.length; i++)
 s[i] = gen.next();
 // Make polymorphic method calls:
 
 highlightShape(s, "Square");
 
 for(Shape shp : s)
 {
	 shp.draw();
	 print(shp.toString());
 }
	 
	 
	 Shape Rh= new Rhomboid(); 
/*	 if (Rh instanceof Rhomboid) 
	 { Rhomboid Rh1=(Rhomboid)Rh;}
	 if (Rh instanceof Circle) 
		 {Circle Cr1 =(Circle)Rh;}
	*/ 
	Shape Cr= new Circle(); 
	 
	Rh.rotate(); 
	Cr.rotate();
 }
} 