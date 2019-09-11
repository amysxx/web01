package web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class TimerListener implements ServletContextListener {

   

    @Override
    public void contextDestroyed(ServletContextEvent arg0)  {
         
    }

	
    //服务器启动后开始计时（ServletContext创建后，开始计时）
    @Override
    public void contextInitialized(ServletContextEvent arg0)  {
        /*
        Timer timer = new Timer();

    	timer.schedule(new TimerTask() {

			public void run() {
				System.out.println("发邮件#######");
			}
		}, 3000, 5000);
         */

        class Task implements Runnable{

            @Override
            public void run() {
                System.out.println ("发送邮件###" );
            }
        }
        Task task1 = new Task ();
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(5);
        scheduledPool.scheduleAtFixedRate (task1,10,3, TimeUnit.SECONDS);

    }
	
}
