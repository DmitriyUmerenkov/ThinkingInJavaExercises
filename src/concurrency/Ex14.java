package concurrency;

import java.util.*;



public class Ex14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i=0;i<1000;i++)
			new Timer().schedule(new TimerTask(){
   			    public void run() {
					System.out.println("Timer done");
														}}, 1000);;
		
		
		
		
	}

}
