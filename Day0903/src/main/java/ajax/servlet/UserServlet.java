package ajax.servlet;

import ajax.bean.User;
import ajax.service.UserService;
import ajax.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fun = request.getParameter("fun");
        System.out.println (fun );
		if("checkusername".equals(fun)){
			checkusername(request,response);
		}
	}
	
	protected void checkusername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String username =request.getParameter("username");
		
		UserService service = new UserServiceImpl ();
		
		User user = service.getUserByUsername(username);
		
		if(user!=null){  // 用户名重复
			//无论是转发还是重定向回客户端，都是整个页面的刷新，无法实现局部刷新
			out.print("no");
			
		}else{  // 用户名可用
			
			out.print("yes");
		}
		
		out.flush();
		out.close();
		
	}
}
