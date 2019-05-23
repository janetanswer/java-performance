package demo.async.function;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author lixing
 * 
 *
 */
@Service
public class AsyncService_CompletableFuture {
	
	public static final Logger logger = LoggerFactory.getLogger(AsyncService_CompletableFuture.class);

	
	@Async("asyncExecutor4seat")
	public CompletableFuture<String> asyncFunc1() throws InterruptedException{
		
		logger.info("CompletableFuture1 test start.");
		
		int iint = new Random().nextInt(10);
		try {
			Thread.sleep(iint*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info(iint+"^CompletableFuture1 test end.");
		return CompletableFuture.completedFuture("asyncFunc1");

	}
	
	@Async("asyncExecutor4seat")
	public CompletableFuture<String> asyncFunc2() throws InterruptedException{
		
		logger.info("CompletableFuture2 test start.");
		
		int iint = new Random().nextInt(10);
		try {
			Thread.sleep(iint*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info(iint+"^CompletableFuture2 test end.");
		return CompletableFuture.completedFuture("asyncFunc2");

	}
	
	
	@Async("asyncExecutor4seat")
	public CompletableFuture<String> asyncFuncBefore() throws InterruptedException{
		
		logger.info("asyncFuncBefore test start.");
		
		int iint = new Random().nextInt(10);
		try {
			Thread.sleep(iint*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info(iint+"^asyncFuncBefore test end.");
		return CompletableFuture.completedFuture("before");

	}
	
	
	@Async("asyncExecutor4seat")
	public CompletableFuture<String> asyncFuncAfter(String str) throws InterruptedException{
		
		logger.info("asyncFuncAfter test start.");
		
		int iint = new Random().nextInt(10);
		try {
			Thread.sleep(iint*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info(iint+"^asyncFuncAfter test end.");
		return CompletableFuture.completedFuture(str+"^after");

	}
	
	
	public CompletableFuture<Boolean> getFirstPage(){
		
		logger.info("getFirstPage test start.");
    	CompletableFuture<Boolean> completableFuture = new CompletableFuture<Boolean>();
    	
    	int iint = new Random().nextInt(10);
		try {
			Thread.sleep(iint*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	completableFuture.complete(Boolean.TRUE);
    	
    	logger.info(iint+"^getFirstPage test end.");
    	return completableFuture;
    }
	
}
