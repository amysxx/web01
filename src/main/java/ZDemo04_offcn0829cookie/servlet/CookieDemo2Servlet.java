package ZDemo04_offcn0829cookie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieDemo2Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取浏览器中的Cookie
		Cookie[] cs = request.getCookies();  //如果客户端一个Cookie都没有 cs的值为null
		
		if(cs!=null){
			
			for(Cookie c:cs){
				System.out.println(c.getName()+"\t"+c.getValue());
			}
		}
		
	}

}
