package chapter3;

public class Ex4 {

	public static void main(String[] args) {
		boolean IsPrime;
		for (int i=0;i<100;i++)
		{
			IsPrime=true;
			for (int j=2;j<i;j++)
				if (i%j==0) IsPrime=false;
		if(IsPrime) System.out.println(i);
		}
	}

}
