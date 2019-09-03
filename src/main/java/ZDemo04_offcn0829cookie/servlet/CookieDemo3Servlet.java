package ZDemo04_offcn0829cookie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieDemo3Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 使用Cookie完成，如果是第一次访问这个Servlet 在页面显示欢迎第一次方法
		 *             如果不是第一次访问这个Servlet 在页面显示欢迎回来
		 *
		 * 思路： 访问这个Servlet时，获取响应的Cookie。
		 * 如果没有找到说明是第一次访问 1、显示欢迎第一次方法，2 做一个Cookie带给客户端
		 *
		 * 如果找到了，说明来过，显示欢迎回来
		 *
		 *
		 * */
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		Cookie[] cs = request.getCookies();

		boolean flag = false;

		if(cs!=null){
			for(Cookie c:cs){
				if("visited".equals(c.getName())){
					flag = true;
					break;
				}
			}

		}

		if(flag){  //不是第一次访问
			out.print("欢迎回来");
		}else{  //是第一次访问
			out.print("欢迎第一次访问");

			Cookie c = new Cookie("visited","true");

			c.setMaxAge(10000);

			response.addCookie(c);
		}


		out.flush();
		out.close();


	}

}
