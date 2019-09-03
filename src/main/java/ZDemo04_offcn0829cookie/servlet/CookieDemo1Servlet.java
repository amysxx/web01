package ZDemo04_offcn0829cookie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieDemo1Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1 创建Cookie
		Cookie c = new Cookie("companyName","offcn");  // 参数：  name   value    不能使用非英文字符
		
/*
		//2 获取Cookie的name 
		String name = c.getName();
		System.out.println(name);
		//3 获取Cookie的value
		String value = c.getValue();
		System.out.println(value);
		//Cookie中没有根据name获取value的方法
*/
		// 把Cookie写给客户端(浏览器)
		
		//设置Cookie的存活时间    当不设置Cookie的存活时间时，Cookie是存在浏览器的内存中的，叫做瞬时Cookie
		c.setMaxAge(60*60*24*7);  //设置了存活时间后，就是持久化Cookie，会保存在浏览器的磁盘文件中
		
		//c.setPath("/Day0829-cookie/");  // 设置Cookie的有效路径—— 在/Day0829-cookie下所有资源可以方法这个Cookie
		c.setPath("/"); //当前tomcat下的项目都可以方法这个Cookie
		
		
		response.addCookie(c);
		
	}

}
