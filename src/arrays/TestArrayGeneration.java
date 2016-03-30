package arrays;

import java.util.*;
import util.*;
import static util.Print.*;
import java.math.*;


public class TestArrayGeneration {
  public static void main(String[] args) {
    int size = 6;
    boolean[] a1 = ConvertTo.primitive(Generated.array(
      Boolean.class, new SkipGenerator.Boolean(true), size));
    print("a1 = " + Arrays.toString(a1));
    byte[] a2 = ConvertTo.primitive(Generated.array(
      Byte.class, new SkipGenerator.Byte((byte)2), size));
    print("a2 = " + Arrays.toString(a2));
    char[] a3 = ConvertTo.primitive(Generated.array(
      Character.class,
      new SkipGenerator.Character(2), size));
    print("a3 = " + Arrays.toString(a3));
    short[] a4 = ConvertTo.primitive(Generated.array(
      Short.class, new SkipGenerator.Short((short)2), size));
    print("a4 = " + Arrays.toString(a4));
    int[] a5 = ConvertTo.primitive(Generated.array(
      Integer.class, new SkipGenerator.Integer(2), size));
    print("a5 = " + Arrays.toString(a5));
    long[] a6 = ConvertTo.primitive(Generated.array(
      Long.class, new SkipGenerator.Long(2), size));
    print("a6 = " + Arrays.toString(a6));
    float[] a7 = ConvertTo.primitive(Generated.array(
      Float.class, new SkipGenerator.Float(2.5f), size));
    print("a7 = " + Arrays.toString(a7));
    double[] a8 = ConvertTo.primitive(Generated.array(
      Double.class, new SkipGenerator.Double(2.55), size));
    print("a8 = " + Arrays.toString(a8));
    BigDecimal[] bd = Generated.array(BigDecimal.class, new CountingGenerator.BigDecimalG(), size);
    print ("bd=" + Arrays.toString(bd));
  
  }
}
