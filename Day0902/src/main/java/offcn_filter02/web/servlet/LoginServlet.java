package offcn_filter02.web.servlet;

import offcn_filter02.bean.User;
import offcn_filter02.service.UserService;
import offcn_filter02.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService service = new UserServiceImpl ();
		
		User user = service.login(username, password);
		
		if(user!=null){ //登录成功
			
			request.getSession().setAttribute("user",user);
			response.sendRedirect("index.jsp");
			
		}else{ //登录失败
			
			response.sendRedirect("login.jsp");
		}
		
		
	}

}
