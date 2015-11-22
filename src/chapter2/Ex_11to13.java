package chapter2;

public class Ex_11to13 {
	
	static void BinaryChar (char c) {
		System.out.println(Integer.toBinaryString((int)c));
		
		}

	
	
	
	
	public static void main(String[] args) {
		
		BinaryChar('a');
		BinaryChar('c');
		BinaryChar('z');
		BinaryChar('Z');
		
		
		int i1=0x80000000;

		
		System.out.println("i1 "+ Integer.toBinaryString(i1));
	
		for (int i=0;i<32;i++)
		{
			i1=i1>>1;
			System.out.println("i1 "+ Integer.toBinaryString(i1));
		}
		
		i1=i1<<1;
		System.out.println("i1 "+ Integer.toBinaryString(i1));

		
		
		for (int i=0;i<32;i++)
		{
			i1=i1>>>1;
			System.out.println("i1 "+ Integer.toBinaryString(i1));
			
		}

	}

}
