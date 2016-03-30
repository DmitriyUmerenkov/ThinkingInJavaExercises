package io;

import java.io.*;


class Serie1 implements Serializable {
	static int count=0;
	final int id =count++;
	double d;
	Serie2 ser;
	Serie1 (double d, Serie2 ser) {this.d=d; this.ser=ser;}
	
	public String toString() {return "Serie2 id: "+id+ " contents="+d+"| ser2:"+ser.toString();}
	
}


class Serie2 implements Serializable {
	static int count=0;
	final int id =count++;
	
	String s;
	
	Serie2 (String s) {this.s=s;}
	
	public String toString(){
		return "Serie2 id: "+id+" content=" +s;
	}
	
}



public class Ex27 {

	public static void main(String[] args) throws Exception {
		
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("ex27.out")); 
		
		os.writeObject(new Serie1(10.10, new Serie2("one")));
		os.writeObject(new Serie1(20.20, new Serie2("two")));		
		
		os.close();
		
		ObjectInputStream is = new ObjectInputStream(new FileInputStream("ex27.out")); 
		
		System.out.println(is.readObject().toString());
		System.out.println(is.readObject().toString());
		is.close();
		
	}
	
}
