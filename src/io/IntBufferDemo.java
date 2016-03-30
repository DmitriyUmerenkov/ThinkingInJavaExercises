package io;

import java.nio.*;
public class IntBufferDemo {
  private static final int BSIZE = 1024;
  public static void main(String[] args) {
    long time = System.nanoTime();
	ByteBuffer bb = ByteBuffer.allocate(BSIZE);
	time = System.nanoTime()-time;
	System.out.println("Allocating time = "+ time);
    time = System.nanoTime();
	DoubleBuffer ib = bb.asDoubleBuffer();
    // Store an array of int:
    ib.put(new double[]{ 11, 42, 47, 99, 143, 811, 1016 });
    // Absolute location read and write:
    System.out.println(ib.get(3));
    ib.put(3, 1811);
    // Setting a new limit before rewinding the buffer.
    ib.flip();
    while(ib.hasRemaining()) {
      double i = ib.get();
      System.out.println(i);
    }
  	time = System.nanoTime()-time;
  	System.out.println("Operation time = "+ time);
  	
    time = System.nanoTime();
	bb = ByteBuffer.allocateDirect(BSIZE);
	time = System.nanoTime()-time;
	System.out.println("Direct allocating time = "+ time);
    time = System.nanoTime();
	ib = bb.asDoubleBuffer();
    // Store an array of int:
    ib.put(new double[]{ 11, 42, 47, 99, 143, 811, 1016 });
    // Absolute location read and write:
    System.out.println(ib.get(3));
    ib.put(3, 1811);
    // Setting a new limit before rewinding the buffer.
    ib.flip();
    while(ib.hasRemaining()) {
     double i = ib.get();
      System.out.println(i);
    }

      time = System.nanoTime()-time;
  	System.out.println("Direct operation time = "+ time);

  }  	

} 
