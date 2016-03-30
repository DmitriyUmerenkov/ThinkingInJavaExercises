package concurrency;

import java.util.concurrent.*;

class Wrapper {
	int even=2;
	int odd=1;
	
	synchronized int getEven(){return even;}
	synchronized int getOdd(){return odd;}
	
	synchronized void nextEven()
	{
		for (int i=0;i<2000;i++)
			even++;
	}
	
	
	synchronized void nextOdd()
	{
		for (int i=0;i<2000;i++)
			odd++;		
	}
}


class Getter implements Runnable{
		Wrapper w;

		Getter(Wrapper w) {this.w = w;}

		@Override
		public void run() {
			for (int i=0;i<100;i++) {
				System.out.println("OddValue "+w.getOdd());
				w.nextOdd();
				System.out.println("EvenValue "+w.getEven());
				w.nextEven();
			}
		}	
}



public class Ex11 {

	public static void main(String[] args) {
	
 Wrapper wrap = new Wrapper();
ExecutorService exec =  Executors.newCachedThreadPool();
	 for (int i=0;i<5;i++)
		 exec.execute(new Getter(wrap));
  
	}

}
