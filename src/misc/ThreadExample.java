package misc;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadExample {
	
	class CallableExample implements Callable<String> {
		private String name;
		private CyclicBarrier barrier;
		private int t;
		public CallableExample(String input, CyclicBarrier b, int t) {
			this.name = input;
			this.barrier = b;
			this.t = t;
		}
		public String call() {
			System.out.println(name + " is running");
			try {
				System.out.println(name + " is going to sleep");
				Thread.currentThread().sleep(t);
				System.out.println(name + " woke up from sleep.. awaiting");
				barrier.await();
				System.out.println(name + " done with await");
			}catch(Exception e) {
				
			}
			return name + " is done";
		}
	}
	
	public static void main(String args[]) {
		ThreadExample te = new ThreadExample();
		CyclicBarrier b = new CyclicBarrier(3);
		
		FutureTask<String> f1 = new FutureTask(te.new CallableExample("a", b, 1000));
		Thread t1 = new Thread(f1);
		FutureTask<String> f2 = new FutureTask(te.new CallableExample("b", b, 5000));
		Thread t2 = new Thread(f2);
		FutureTask<String> f3 = new FutureTask(te.new CallableExample("c", b, 10000));
		Thread t3 = new Thread(f3);
		
		t1.start();
		t2.start();
		t3.start();

		try {
			System.out.println(f1.get());
			System.out.println(f2.get());
			System.out.println(f3.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
