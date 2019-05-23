package demo.async.function;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

@RestController
@RequestMapping("/brightstar")
public class MainController {

	public static final Logger logger = LoggerFactory.getLogger(MainController.class);

	ExecutorService exec = Executors.newCachedThreadPool();

	@Autowired
	AsyncService_Future asyncService;
	
	@Autowired
	AsyncService_CompletableFuture asyncService_c;

	/* http://localhost:8080/brightstar/CA101 */
	@RequestMapping(value = "/{flightNo}", method = RequestMethod.GET)
	public String simpleExp(@PathVariable String flightNo) {
		asyncService.function(flightNo);
		asyncService.function(flightNo);
		asyncService.function(flightNo);

		return "finish" + LocalTime.now().getSecond();
	}

	@RequestMapping("/d")
	public DeferredResult<byte[]> DefferedExp(@RequestParam(value = "name", defaultValue = "World") String name) {
		DeferredResult<byte[]> deferredResult = new DeferredResult<>();

		exec.execute(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					// 等待三秒，模拟耗时或阻塞操作
					TimeUnit.MILLISECONDS.sleep(3000);
					System.out.println("业务处理线程方法执行完毕时间 : " + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime()) + "秒");
					byte[] bs = "123456".getBytes();
					deferredResult.setResult(bs);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		System.out.println("请求处理线程方法执行完毕时间  : " + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime()) + "秒");

		return deferredResult;

	}

	@RequestMapping("/w")
	public WebAsyncTask<byte[]> WebAsyncExp(@RequestParam(value = "name", defaultValue = "World") String name) {

		Callable<byte[]> callable = new Callable<byte[]>() {

			@Override
			public byte[] call() throws Exception {
				// TODO Auto-generated method stub
				try {
					// 等待三秒，模拟耗时或阻塞操作
					TimeUnit.MILLISECONDS.sleep(3000);
					System.out.println("业务处理线程方法执行完毕时间 : " + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime()) + "秒");
					byte[] bs = "654321".getBytes();
					return bs;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		};

		System.out.println("请求处理线程方法执行完毕时间  : " + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime()) + "秒");

		return new WebAsyncTask<byte[]>(callable);
	}

	@RequestMapping(value = "/testAsynch", method = RequestMethod.GET)
	public void testAsynch() throws InterruptedException, ExecutionException {
		logger.info("===========testAsynch Start==============");

//		CompletableFuture<String> ret1 = asyncService_c.asyncFunc1();
//		CompletableFuture<String> ret2 = asyncService_c.asyncFunc2();

		// Wait until they are all done
//		CompletableFuture.allOf(ret1,ret2).join();
//		logger.info("{}+{}",ret1.get(),ret2.get());
		
		//wait until just one done
//		logger.info((String) CompletableFuture.anyOf(ret1,ret2).get());
		
		//前后关系依赖
//		CompletableFuture<String> retb = asyncService_c.asyncFuncBefore();
//		CompletableFuture<String> reta = asyncService_c.asyncFuncAfter(retb.get());
//		logger.info(reta.get());
		
		logger.info(asyncService_c.getFirstPage().get().toString());
	}

}
