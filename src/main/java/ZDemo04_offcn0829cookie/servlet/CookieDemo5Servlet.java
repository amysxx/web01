package ZDemo04_offcn0829cookie.servlet;

import ZDemo04_offcn0829cookie.util.CookieUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/*
 * 利用Cookie记录客户端访问次数
 * 
 * 思路：
 *    找想要的Cookie 1 找不到：第一次访问  
 *                2 找到了，获得次数显示，+1再写到Cookie中
 * */
@WebServlet("/CookieDemo5Servlet")
public class CookieDemo5Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cs = request.getCookies();
		
		Cookie c = CookieUtils.findCookieByName("count", cs);
		
		int num = 0;
		String date = null;
		if(c==null){
			num = 1;
		}else{
			num = Integer.parseInt(c.getValue());
			date = c.getValue ();
		}
		out.print("<h1>第"+num+"次访问</h1>");
		
		Cookie cookie  = new Cookie("count",(++num)+"");
        Cookie cookie1 = new Cookie("lasttime",new Date ()+"");
		cookie.setMaxAge(10000);
		response.addCookie(cookie);
		response.addCookie (cookie1);
		out.flush();
		out.close();
		
	}

}
