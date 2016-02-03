package chapter7;

import static util.Print.*;
import java.util.*; 

class Shape {
	 public void draw() {}
	 public void erase() {}
	 public void name() {print("A Shape");} 
} 


class Circle extends Shape {
@Override
 public void draw() { print("Circle.draw()"); }
@Override
public void erase() { print("Circle.erase()"); }
@Override
public void name() {print("A Circle");} 


} 

 class Square extends Shape {
	 @Override
	 public void draw() { print("Square.draw()"); }
	 @Override
	 public void erase() { print("Square.erase()"); }
	 @Override
	 public void name() {print("A Square");} 

 } 

class Triangle extends Shape {
	@Override
	public void draw() { print("Triangle.draw()"); }
	@Override
	public void erase() { print("Triangle.erase()"); }
	@Override
	public void name() {print("A Triangle");} 

}

class Ellipse extends Shape {
	@Override
	public void draw() { print("Ellipse.draw()"); }
	@Override
	public void erase() { print("Ellipse.erase()"); }
	@Override
	public void name() {print("An Ellipse");} 

}


class RandomShapeGenerator {
	 private Random rand = new Random();
	 public Shape next() {
	 switch(rand.nextInt(4)) {
	 default:
	 case 0: return new Circle();
	 case 1: return new Square();
	 case 2: return new Triangle();
	 case 3: return new Ellipse();
	 }
	 }
	} 



public class Ex2to4 {

	private static RandomShapeGenerator gen =
			 new RandomShapeGenerator();
			 public static void main(String[] args) {
			 Shape[] s = new Shape[9];
			 // Fill up the array with shapes:
			 for(int i = 0; i < s.length; i++)
			 s[i] = gen.next();
			 // Make polymorphic method calls:
			 for(Shape shp : s)
			 {
				 shp.draw();
				 shp.name();
			 }
			 } 
	
	
}
