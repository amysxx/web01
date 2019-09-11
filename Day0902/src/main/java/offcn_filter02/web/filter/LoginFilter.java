package offcn_filter02.web.filter;

import offcn_filter02.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/admin/*")
public class LoginFilter implements Filter {

   
	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(user!=null){  //已经登录过
			
			chain.doFilter(req,resp);
			
		}else{  // 没登录过
			
			resp.sendRedirect(req.getContextPath()+"/login.jsp?msg=pleaselogin");
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
      
	}

}
