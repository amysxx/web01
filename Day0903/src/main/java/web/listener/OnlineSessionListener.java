package web.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class OnlineSessionListener implements HttpSessionListener {


	
    @Override
    public void sessionCreated(HttpSessionEvent arg0)  {
       
    	ServletContext sc = arg0.getSession().getServletContext();
    	
    	Integer count = (Integer)sc.getAttribute("num");
    	if(count==null){
    		sc.setAttribute("num",1);
    	}else{
    		sc.setAttribute("num", ++count);
    	}
    	
    }

	
    @Override
    public void sessionDestroyed(HttpSessionEvent arg0)  {
        
    	ServletContext sc = arg0.getSession().getServletContext();
    	Integer count = (Integer)sc.getAttribute("num");
    	sc.setAttribute("num", --count);
    	
    }
	
}
