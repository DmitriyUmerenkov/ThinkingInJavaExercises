package chapter3;

public class Ex4_1 {

	public static void main(String[] args) {
		OuterLabel:
		for (int i=0;i<100;i++)
		{
			for (int j=2;j<i;j++) if (i%j==0) continue OuterLabel;
			System.out.println(i);
		}
	}

}
