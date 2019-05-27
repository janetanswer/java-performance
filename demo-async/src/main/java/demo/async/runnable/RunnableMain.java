package demo.async.runnable;

public class RunnableMain {

	public static void main(String[] args){ 
		
		System.out.println("Main ThreadName:"+Thread.currentThread().getName());
		
		RunnableImpl runnableImpl = new RunnableImpl();
		
		for(int i=0;i<10;i++) {
			Thread thread = new Thread(runnableImpl);
			thread.start();
		}
		
		
	}
}
