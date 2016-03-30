package concurrency;

import java.util.concurrent.*;

public class GenericFibonacci implements Callable, Runnable{
	static int counter;
	final int id=counter++;
	static ExecutorService exec1 = Executors.newCachedThreadPool();
	
	  public Future runTask(int toSum) {
		 Callable<Integer> c = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int result=0;
	        	for (int i =0;i<toSum;i++) result+=fib(i);
	        	return result;
			}};

		return exec1.submit(c);
	}
		
	int n;
	GenericFibonacci(int n) {this.n=n;}
	
	private int fib(int n) {
		if(n < 2) return 1;
		return fib(n-2) + fib(n-1);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		GenericFibonacci fib = new GenericFibonacci(0);
	
		for (int i=0;i<10;i++)
		{
			//new Thread(new GenericFibonacci(i)).start();
			System.out.println("Sum of first "+ i +" fibonacci numbers is :" + fib.runTask(i).get()    );
			//exec1.execute(new GenericFibonacci(i));
		
		
		
		}
	}


	@Override
	public void run() {
		for (int i=0;i<n;i++) {
			System.out.println("Process#" + id+ " step # "+ i+ " number:"+fib(i));
						
		}
		
	}

	@Override
	public Integer call() throws Exception {
		int result=0;
		for (int i=0;i<n;i++) {
			result+=fib(i);						
		}
		return result;
	}

}
