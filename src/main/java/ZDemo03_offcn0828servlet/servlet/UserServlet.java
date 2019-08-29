package ZDemo03_offcn0828servlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request, response);
	}

	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request中封装了Http请求的全部信息 包括  请求行，请求头  ，请求体

		// 获取请求行信息
		String method = request.getMethod();  // 请求方式
		String url = request.getRequestURL().toString();  //请求路径
		String uri = request.getRequestURI();
		String protocal = request.getProtocol();    //协议
		String contextPath= request.getContextPath();  // 项目名(context root)
		long port = request.getServerPort();  //端口号
		String queryString = request.getQueryString();  // 获得请求地址中 ? 后带的值
		String ip =request.getRemoteAddr();  //客户端ip
		
		System.out.println("请求方式："+method);
		System.out.println("请求地址："+url);
		System.out.println("uri："+uri);
		System.out.println("协议："+protocal);
		System.out.println("项目名："+contextPath);
		System.out.println("端口："+port);
		System.out.println("queryString："+queryString);
		System.out.println("ip："+ip);

	/*	
		//获取请求头信息
		String accept = request.getHeader("accept");
		String referer = request.getHeader("referer");
		String userAgent = request.getHeader("user-agent");
		
		System.out.println(accept);
		System.out.println(referer);
		System.out.println(userAgent);
		
		Enumeration<String> es = request.getHeaderNames();
		while(es.hasMoreElements()){
			System.out.println(es.nextElement());
		}
		*/
	
	    
	}

}
