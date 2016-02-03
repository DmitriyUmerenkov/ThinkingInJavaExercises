package chapter8;
import static util.Print.*;

class StringSwap implements Processor {

	public String name() {return "String Swap";}
	
	public String process(Object s) {
		
		char[] result=new char[((String)s).length()];
		
		for (int i=0;i<(((String)s).length()-((String)s).length()%2)/2;i++)
		{
			result[i*2]=((String)s).toCharArray()[i*2+1];
			result[i*2+1]=((String)s).toCharArray()[i*2];
		}
		if (((String)s).length()%2==1)
			result[((String)s).length()-1]=(((String)s).toCharArray())[((String)s).length()-1];
		return new String(result);

	}
}

public class Apply {

	
	public static void process(Processor p, Object s) {
		 print("Using Processor " + p.name());
		 print(p.process(s));
		 } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process(new StringSwap(), "abcdefgh");
		process(new StringSwap(), "123456789");
	}

}
