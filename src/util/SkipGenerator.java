package util;

public class SkipGenerator {

	  public static class
	  Boolean implements Generator<java.lang.Boolean> {
	    private boolean value = false;
	    private boolean skip=false;
	    public java.lang.Boolean next() {
	      if(!skip) value = !value; // Just flips back and forth
	      return value;
	    }
	  public Boolean(boolean skip) {this.skip=skip;}
	  }

	  public static class
	  Byte implements Generator<java.lang.Byte> {
	    private byte skip=1;
		private byte value = 0;
	    public java.lang.Byte next() { return value+=skip; }
	  
	  public Byte(byte skip) {this.skip=skip;}
	  }
	   
	  static char[] chars = ("abcdefghijklmnopqrstuvwxyz" +
	    "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
	  public static class
	  Character implements Generator<java.lang.Character> {
	    int skip=1;
		int index = -1;
	    public java.lang.Character next() {
	      index = (index + skip) % chars.length;
	      return chars[index];
	    }
	    public Character(int skip) {this.skip=skip;}
	  }
	  public static class
	  String implements Generator<java.lang.String> {
	    private int length = 7;
	    Generator<java.lang.Character> cg;
	    public String(int skip) { cg = new Character(skip);}
	    public String(int skip, int length) { this.length = length; cg = new Character(skip); }
	    public java.lang.String next() {
	      char[] buf = new char[length];
	      for(int i = 0; i < length; i++)
	        buf[i] = cg.next();
	      return new java.lang.String(buf);
	} }

	  public static class
	  Short implements Generator<java.lang.Short> {
	    private short value = 0;
	    short skip=1;
	    public java.lang.Short next() { return value+=skip; }
	    public Short(short skip) {this.skip=skip;}
	  }
	  
	  public static class
	  Integer implements Generator<java.lang.Integer> {
	    private int value = 0;
	    int skip=1;
	    public java.lang.Integer next() { return value+=skip; }
	    public Integer(int skip) {this.skip=skip;}
	  }
	  
	  public static class
	  Long implements Generator<java.lang.Long> {
	    private long value = 0;
	    long skip=1;
	    public java.lang.Long next() { return value+=skip; }
	    public Long(long skip) {this.skip=skip;}
	  }
	  
	  public static class
	  Float implements Generator<java.lang.Float> {
	    private float value = 0;
	    float skip=1.0f;
	    public java.lang.Float next() {
	      float result = value;
	      value+=skip;
	      return result;
	} 
	    public Float(float skip) {this.skip=skip;}  
	  }
	  
	  public static class
	  Double implements Generator<java.lang.Double> {
	    private double value = 0.0;
	    double skip=1.0;
	    public java.lang.Double next() {
	      double result = value;
	      value+=skip;
	      return result;
	} 
	    public Double(double skip) {this.skip=skip;}    
	  }	
	
	
}
