package offcn_filter02.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

 

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
