package ZDemo01_offcn0827servlet.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/Demo07ServletConfigTestServlet")
public class Demo07ServletConfigTestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ServletConfig
		
		ServletConfig config = this.getServletConfig();
		
		String servletname = config.getServletName();
		System.out.println(servletname);
		
		// 获得初始化参数
		String value=config.getInitParameter("path");
		System.out.println(value);
		
		//获取所有初始化参数的name
		Enumeration<String> ems = config.getInitParameterNames();
		while(ems.hasMoreElements()){
			System.out.println(ems.nextElement());
		}
		
		// 获取ServletContext对象
		ServletContext sc = config.getServletContext();
		ServletContext sc2 = this.getServletContext();
		
	}

}
