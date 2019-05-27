package demo.async.runnable;

public class RunnableImpl implements Runnable{

	@Override
	public void run() {
		System.out.println("Sub ThreadName:"+Thread.currentThread().getName());
		
	}

}
