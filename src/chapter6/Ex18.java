package chapter6;
import static util.Print.print;

class Fin {
	static final int VAL=10;
	final int Val1;
	
	Fin (int i) {Val1=i;}
	
}

public class Ex18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Fin f1 =new Fin(1);
Fin f2 =new Fin(2);

print ("f1 VAL "+ f1.VAL+" Val1 "+f1.Val1);
print ("f2 VAL "+ f2.VAL+" Val1 "+f2.Val1);
		
	}

}
