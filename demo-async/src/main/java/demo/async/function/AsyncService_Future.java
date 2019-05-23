package demo.async.function;

import java.util.Random;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class AsyncService_Future {
	
	public static final Logger logger = LoggerFactory.getLogger(AsyncService_Future.class);
	
	
	@Async
	public Future<String> function(String flightNo){
		int iint = new Random().nextInt(10);
		try {
			Thread.sleep(iint*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info(iint+"flightNo is:"+flightNo+Thread.currentThread().getName());
		Future<String> future = new AsyncResult<String>("success");

		return future;
	}
	

}
