package ZDemo01_offcn0827servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Demo01Servlet extends HttpServlet {

	public void init() throws ServletException {
		System.out.println("Demo01Servlet对象出生了......");
	}
	
    public void destroy() {
		System.out.println("Servlet对象升天了####");
	}
	/*
    public Demo01Servlet(){
    	System.out.println("Demo01SServlet的构造方法执行了######");
    }

	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
