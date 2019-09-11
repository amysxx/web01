package web.servlet;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   this.doPost(request, response);
	}

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String username =request.getParameter("username");
	    String password = request.getParameter("password");
	    String checkcode = request.getParameter("checkcode");  // 用户填写的验证码
	    
	    
	    HttpSession session =request.getSession();
	    String code = (String)session.getAttribute("checkcode"); // 从session中获取的生成的验证码
	    
	    UserService service = new UserServiceImpl ();
	    
	    if(code.equalsIgnoreCase(checkcode)){
	    	User user = service.login(username, password);
	    	if(user!=null){
	    		session.setAttribute("user", user);
	    		response.sendRedirect("index.jsp");
	    		
	    	}else{
	    		response.sendRedirect("login.jsp?msg=loginerror");
	    	}
	    }else{
	    	
	    	response.sendRedirect("login.jsp?msg=checkcodeerror");
	    }
	    
	    
	}

}
