package demo.async.ThreadPoolExecutorExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.async.runnable.RunnableImpl;

/**
 * @author lixing
 * 
 * Executor的各种初始化方法
 *
 */
public class FixedThreadPoolExecutorExample {
	
	/**
	 * newFixedThreadPool:创建可重用且固定线程数(3)的线程池.
	 * 
	 * 使用一个基于FIFO排序的阻塞队列，如果线程池中的所有线程都处于活动状态，此时再提交任务就在队列中等待，直到有可用线程.
	 * 
	 * 如果线程池中的某个线程由于异常而结束时，线程池就会再补充一条新线程。
	 * 
	 * 
	 * */
	static ExecutorService fixedThreadPoolExecutor = Executors.newFixedThreadPool(3);
	
	
	public static void main(String[] args){ 
		
		System.out.println("Main ThreadName:"+Thread.currentThread().getName());
		
		RunnableImpl runnableImpl = new RunnableImpl();
		
		for(int i=0;i<10;i++) {
			fixedThreadPoolExecutor.execute(runnableImpl);
		}
		
		
	}
	
	
	
}
