package demo.async.thread;

public class ThreadImpl extends Thread{
	
	
	public void run() {
		System.out.println("Sub ThreadName:"+Thread.currentThread().getName());
	}
}
