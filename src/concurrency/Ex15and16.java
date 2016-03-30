package concurrency;

import java.util.concurrent.*;
import java.util.*;
import java.util.concurrent.locks.*;

public class Ex15and16 {
	Object Sync1 = new Object();
	Object Sync2 = new Object();
	Object Sync3 = new Object();
	
	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();
	Lock lock3 = new ReentrantLock();

	
	void f() {
		lock1.lock();
		try{
   //	synchronized (Sync1 ){
		for (int i=0;i<5;i++)
			System.out.println("f()");
		}
	//	}
		finally {lock1.unlock();}
	}
	void g() {
		lock2.lock();
		try{
   //	synchronized (Sync1 ){
		for (int i=0;i<5;i++)
			System.out.println("g()");
		}
	//	}
		finally {lock2.unlock();}
		}
	void h() {
		lock3.lock();
		try{
   //	synchronized (Sync1 ){
		for (int i=0;i<5;i++)
			System.out.println("h()");
		}
	//	}
		finally {lock3.unlock();}	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		final Ex15and16 obj = new Ex15and16();
		
		for (int i=0;i<10;i++) exec.execute(new Runnable (){

			@Override
			public void run() {
				for (int i=0;i<10;i++)
				switch(new Random().nextInt(3)){
				case 0: obj.f(); break;
				case 1: obj.g(); break;
				case 2: obj.h(); break;
				}
				
			}});
		

	}

}
