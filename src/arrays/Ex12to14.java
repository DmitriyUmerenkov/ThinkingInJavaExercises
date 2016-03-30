package arrays;

import java.util.Arrays;

import util.*;


public class Ex12to14 {

	
	public static void main (String[] args) 
	{
		int length=10;
		
		
		
		
		String str;
		Generator<Character> gen2 = new CountingGenerator.Character(); 
		StringBuilder sb=new StringBuilder();
		for (int i=0;i<length;i++) sb.append(gen2.next());
		str= new String(sb);
		System.out.println(str);
		
		
		byte[] b = new byte[length];
		Generator<Byte> genb= new CountingGenerator.Byte();
		short[] s = new short[length];
		Generator<Short> gens= new CountingGenerator.Short();
		int[] i = new int[length];
		Generator<Integer> geni= new CountingGenerator.Integer();
		long[] l = new long[length];
		Generator<Long> genl= new CountingGenerator.Long();
		float[] f = new float[length];
		Generator<Float> genf= new CountingGenerator.Float();
		boolean[] bool = new boolean[length];
		Generator<Boolean> genbool= new CountingGenerator.Boolean();
		char[] c = new char[length];
		Generator<Character> genc= new CountingGenerator.Character();
		double[] d = new double[length];
		Generator<Double> gend= new CountingGenerator.Double();
	
		for (int j=0;j<length;j++) {
		b[j]=genb.next();
		s[j]=gens.next();
		i[j]=geni.next();
		l[j]=genl.next();
		f[j]=genf.next();
		bool[j]=genbool.next();
		c[j]=genc.next();
		d[j]=gend.next();
			}
		
		
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(s));
		System.out.println(Arrays.toString(i));
		System.out.println(Arrays.toString(l));
		System.out.println(Arrays.toString(f));
		System.out.println(Arrays.toString(bool));
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(d));
		
		
		
		
	}
	
}
