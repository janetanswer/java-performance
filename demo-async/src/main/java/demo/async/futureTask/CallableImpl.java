package demo.async.futureTask;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println("CallableImpl Sub ThreadName:"+Thread.currentThread().getName());
		Thread.sleep(20);
		return Thread.currentThread().getName();
	}

}
