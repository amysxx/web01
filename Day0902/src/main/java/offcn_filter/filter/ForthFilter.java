package offcn_filter.filter;

import javax.servlet.*;
import java.io.IOException;


public class ForthFilter implements Filter {

  
	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("ForthFilter...doFilter...");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}