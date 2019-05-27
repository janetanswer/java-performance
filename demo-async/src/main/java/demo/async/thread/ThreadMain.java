package demo.async.thread;

public class ThreadMain {
	
	public static void main(String[] args){  
		
		System.out.println("Main ThreadName:"+Thread.currentThread().getName());
		for(int i=0;i<10;i++) {
			new ThreadImpl().start();
		}
		
		
	}

}
