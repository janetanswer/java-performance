package demo.async.ThreadPoolExecutorExample;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import demo.async.runnable.RunnableImpl;

public class ScheduledExecutorServiceExample {

	
	/**
	 * 创建固定长度的线程池，而且以延迟或者定时的方式来执行任务
	 * 参数为corePoolSize
	 * 
	 * 
	 */
	static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
	
	
	
	public static void main(String[] args){ 
		
		System.out.println("Main ThreadName:"+Thread.currentThread().getName());
		
		RunnableImpl runnableImpl = new RunnableImpl();
		
		/**
		 * 延时5s执行第一次，每3s执行一次
		 * 
		 * Attention1:定时任务执行的时间一定要比间隔的时间短,否则即使是多线程，也不能做到固定间隔的启动
		 * Attention2:如果定时任务执行延时了，后面会把所有积压的任务都完成，再恢复正常的任务间隔
		 * */
//		scheduledExecutorService.scheduleAtFixedRate(runnableImpl, 5, 3, TimeUnit.SECONDS);
		
		/**
		 * 延时5s执行第一次，每个任务执行完后3s执行下一次任务
		 * 不论任务多久做完，都间隔3s后再执行下一次
		 * 
		 * */
		scheduledExecutorService.scheduleWithFixedDelay(runnableImpl, 5, 3, TimeUnit.SECONDS);
	
	
	}
}
