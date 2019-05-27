package demo.async.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskExample2 {
	
	ExecutorService executor = Executors.newFixedThreadPool(2);
	
	
	public String getThreadName() throws InterruptedException, ExecutionException {
		FutureTask<String> future = new FutureTask<String>(
                new Callable<String>()
                {
                    public String call() throws InterruptedException
                    {
                    	System.out.println("CallableImpl Sub ThreadName:"+Thread.currentThread().getName());
                		Thread.sleep(20);
                		return Thread.currentThread().getName();
                    }
                });
        executor.execute(future);
        
        return future.get();
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException{ 
		
		FutureTaskExample2 fte2 = new FutureTaskExample2();
		for(int i=0;i<5;i++) {
			System.out.println("Result is "+fte2.getThreadName());
		}
		
		
		
		
		
		
		
		
	}
	


}
