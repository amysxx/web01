package web.filter;

import bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
    public void destroy() {
		
	}

	
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String uri = req.getRequestURI();
		
		if(uri.equals(req.getContextPath()+"/login.jsp") || uri.equals(req.getContextPath()+"/LoginServlet") || uri.equals(req.getContextPath()+"/CheckCodeServlet")||uri.equals(req.getContextPath()+"/register.jsp") || uri.equals(req.getContextPath()+"/UserRegisterServlet") || uri.endsWith(".jpg") || uri.endsWith(".js") || uri.endsWith(".css")){
			
			chain.doFilter(req, resp);
		}else{
			HttpSession session =req.getSession();
			User user = (User)session.getAttribute("user");
			
			if(user!=null){
				
				chain.doFilter(req, resp);
			}else{
				resp.sendRedirect("login.jsp?msg=pleaselogin");
			}
			
		}
	}

	@Override
    public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
