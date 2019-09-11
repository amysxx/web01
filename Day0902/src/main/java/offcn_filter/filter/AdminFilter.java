package offcn_filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

	@Override
    public void destroy() {
	}

	
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("AdminFilter###doFilter####");
		chain.doFilter(request, response);
	}

	@Override
    public void init(FilterConfig fConfig) throws ServletException {
	}
}
