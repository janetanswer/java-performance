package demo.async.futureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException{ 
		
		CallableImpl callableImpl = new CallableImpl();
		
		for(int i=0;i<10;i++) {
			FutureTask<String> task = new FutureTask<String>(callableImpl);
			Thread t = new Thread(task);
			t.start();
			String result = task.get();
			System.out.println("result is "+result);
		}
		
		
		
		
		
	}
	


}
