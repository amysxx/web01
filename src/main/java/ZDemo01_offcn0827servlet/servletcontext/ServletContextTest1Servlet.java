package ZDemo01_offcn0827servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ServletContextTest1Servlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute("scname","优就业");
		this.getServletContext().setAttribute("scname","中公教育");
		this.getServletContext().setAttribute("now", new Date());
		this.getServletContext().removeAttribute("now");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取ServletContext(接口) 的对象
		ServletContext sc = this.getServletContext();
		
		String serverInfo = sc.getServerInfo();  //获取服务器信息
		System.out.println(serverInfo);
		
		String contextPath = sc.getContextPath (); // 获得项目名(确切的说不是项目名，而是项目的访问名)
		System.out.println(contextPath);
		
		String initParam = sc.getInitParameter("pname");// 获取全局初始化参数
		System.out.println(initParam);
		
		//相对路径转绝对路径
		String path = sc.getRealPath("/upload");
		System.out.println(path);
	}

}
