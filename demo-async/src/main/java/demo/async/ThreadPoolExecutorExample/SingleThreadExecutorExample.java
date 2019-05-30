package demo.async.ThreadPoolExecutorExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.async.runnable.RunnableImpl;

public class SingleThreadExecutorExample {
	
	 /**
	 * 创建一个单线程的Executor，如果该线程因为异常而结束就新建一条线程来继续执行后续的任务
	 * 
	 * */
	static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
	
	
	public static void main(String[] args){ 
		
		System.out.println("Main ThreadName:"+Thread.currentThread().getName());
		
		RunnableImpl runnableImpl = new RunnableImpl();
		
		for(int i=0;i<10;i++) {
			singleThreadExecutor.execute(runnableImpl);
		}
		
		
	}

}
