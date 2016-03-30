package io;

import java.io.*;
public class UsingRandomAccessFile {
  static String file = "rtest.dat";
  static void display() throws IOException {
    RandomAccessFile rf = new RandomAccessFile(file, "r");
      System.out.println("Value: " + rf.readDouble());
      System.out.println("Value: " + rf.readBoolean());
      System.out.println("Value: " + rf.readByte());
      System.out.println("Value: " + rf.readChar());
      System.out.println("Value: " + rf.readLine());
      System.out.println("Value: " + rf.readFloat());
      System.out.println("Value: " + rf.readInt());
      System.out.println("Value: " + rf.readLong());
      System.out.println("Value: " + rf.readShort());
    System.out.println(rf.readUTF());
    rf.close();
  }
  public static void main(String[] args)
  throws IOException {
    RandomAccessFile rf = new RandomAccessFile(file, "rw");
    rf.writeDouble(7*1.414);
    rf.writeBoolean(true);
    rf.writeByte((byte)255);
    rf.writeChar('c');
    rf.writeChars("A string\n");
    rf.writeFloat(10.101f);
    rf.writeInt(101);
    rf.writeLong(101101101);
    rf.writeShort((short)101);
    rf.writeUTF("The end of the file");
    rf.close();
    display();

  }
}
