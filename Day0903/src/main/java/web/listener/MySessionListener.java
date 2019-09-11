package web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class MySessionListener implements HttpSessionListener {


	
    @Override
    public void sessionCreated(HttpSessionEvent arg0)  {
         System.out.println("HttpSession对象被创建<<<>>>");
    }

	
    @Override
    public void sessionDestroyed(HttpSessionEvent arg0)  {
        System.out.println("HttpSession对象被销毁<<<<>>>>");
    }
	
}
