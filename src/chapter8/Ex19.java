package chapter8;
import static util.Print.*;
import java.util.*;


interface TossGame {
	
int toss();	
}

interface TossGameFactory{
	TossGame getTossGame();
	
}

class CoinToss implements TossGame {
	static Random r=new Random();
	
	public int toss() {return r.nextInt(2);}	
}

class DiceToss implements TossGame {
	static Random r=new Random();

	public int toss() {return 1+ r.nextInt(6);}
	
}

class CoinTossFactory implements TossGameFactory {

	@Override
	public TossGame getTossGame() {
		// TODO Auto-generated method stub
		return new CoinToss();
	}
	
}

class DiceTossFactory implements TossGameFactory {

	@Override
	public TossGame getTossGame() {
		// TODO Auto-generated method stub
		return new DiceToss();
	}
	
}




public class Ex19 {

	public static void playTossGame (TossGameFactory t) {
		final TossGame g= t.getTossGame();
		print(g.toss());
		print(g.toss());
		print(g.toss());
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		playTossGame (new CoinTossFactory());
		playTossGame (new DiceTossFactory());
			
		
	}

}
