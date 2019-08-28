package ZDemo01_offcn0827servlet_02.servlet;

import ZDemo01_offcn0827servlet_02.bean.User;
import ZDemo01_offcn0827servlet_02.service.UserService;
import ZDemo01_offcn0827servlet_02.service.impl.UserServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class UserServlet extends HttpServlet {

	//int num = 1;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService service = new UserServiceImpl ();
		
		User user = service.login(username, password);
		
		if(user!=null){ // 登录成功
			
			/*
			response.setStatus(302); //设置状态码为302 重定向
			response.setHeader("Location","index.html");
			*/
			//response.sendRedirect("index.html");  // 重定向
			//response.sendRedirect("https://www.baidu.com");  // 重定向
			//response.setHeader("refresh","3;https://www.baidu.com");
			
			int num =0;
			
			if(this.getServletContext().getAttribute("num")!=null){ 
				num = (int)this.getServletContext().getAttribute("num");
			}
			this.getServletContext().setAttribute("num", ++num);
			response.sendRedirect("ShowServlet");
			
		}else{ // 登录失败
			/*
			response.setStatus(302); //设置状态码为302 重定向
			response.setHeader("Location","login.html");
			*/
			response.sendRedirect("login.html");  // 重定向
		}
		
		
	}

}
