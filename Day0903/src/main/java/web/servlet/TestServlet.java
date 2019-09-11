package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	   this.getServletContext().setAttribute("aaa","111");
	   this.getServletContext().setAttribute("aaa","222");
	   this.getServletContext().removeAttribute("aaa");
	 */
	/*	
		request.getSession().setAttribute("aaa","111");
		request.getSession().setAttribute("aaa","222");
		request.getSession().removeAttribute("aaa");
		*/
		
		request.setAttribute("aaa","111");
		request.setAttribute("aaa","222");
		request.removeAttribute("aaa");
		
	/*	
		Student stu = new Student();
		request.getSession().setAttribute("stu",stu);
		request.getSession().removeAttribute("stu");
		*/
	/*	
		User user = new User();
		user.setId(1);
		user.setName("xxx");
		request.getSession().setAttribute("user",user);*/
	}

	
}
