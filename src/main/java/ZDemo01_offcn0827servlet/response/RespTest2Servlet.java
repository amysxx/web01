package ZDemo01_offcn0827servlet.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RespTest2Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	
		response.setCharacterEncoding("UTF-8");  // 设置数据存入数组缓冲区中时的编码方式
		response.addHeader("Content-Type", "text/html;charset=utf-8"); // 设置浏览器查看时的编码方式
	*/
		response.setContentType("text/html;charset=utf-8");
		//OutputStream os = response.getOutputStream();  // 在同一个servlet中不能同时获取两种流
		  
		PrintWriter out = response.getWriter();// 获取打印流---->用该打印流输出的内容会输出到客户端浏览器上
		out.print("<h1>hello</h1>");
		out.print("<h1>优就业</h1>");
		
		
		//流可以不写刷新和关闭的代码，父类中会去关闭
		out.flush();
		out.close();
	}

}
