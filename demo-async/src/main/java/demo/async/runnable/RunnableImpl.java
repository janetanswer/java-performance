package demo.async.runnable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RunnableImpl implements Runnable{

	@Override
	public void run() {
		Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String retStrFormatNowDate = sdFormatter.format(nowTime);
		
		System.out.println(retStrFormatNowDate+" Sub ThreadName:"+Thread.currentThread().getName());

		
		try {
			if(ShareObj.num>3) {
				Thread.sleep(1000);
			}else {
				Thread.sleep(4000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ShareObj.num++;
		
	}

}
