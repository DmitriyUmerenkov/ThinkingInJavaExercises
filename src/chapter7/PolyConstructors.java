package chapter7;

import static util.Print.*;

class Glyph {
 void draw() { print("Glyph.draw()"); }
 Glyph() {
 print("Glyph() before draw()");
 draw();
 print("Glyph() after draw()");
 }
}
class RoundGlyph extends Glyph {
 private int radius = 1;
 RoundGlyph(int r) {
 radius = r;
 print("RoundGlyph.RoundGlyph(), radius = " + radius);
 }
 void draw() {
 print("RoundGlyph.draw(), radius = " + radius);
 }
}

class RectangularGlyph extends Glyph {
	 private int height = 1;
	 private int length = 1;

	 RectangularGlyph(int height, int length) {
	 this.height = height;
	 this.length = length;
	 print("RoundGlyph.RoundGlyph(), height and length = " + height+ " "+length);
	 }
	 void draw() {
	 print("RoundGlyph.draw(), height and length = " + height+ " "+length);
	 }
	}



public class PolyConstructors {
 public static void main(String[] args) { 
	 new RectangularGlyph(5,10);
 }
} 
