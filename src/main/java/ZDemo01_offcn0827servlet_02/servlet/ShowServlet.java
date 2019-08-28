package ZDemo01_offcn0827servlet_02.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class  ShowServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doPost(request, response);
	}

	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		response.getOutputStream ();
		int num = (int)this.getServletContext().getAttribute("num");
		
		out.print("<h1>您是第"+num+"位登录成功的用户</h1>");

		//服务器负责管理printWriter,printStream
		out.flush();
		out.close();
		
		
		
	}

}
