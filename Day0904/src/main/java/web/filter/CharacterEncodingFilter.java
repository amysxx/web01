package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

    
	@Override
    public void destroy() {
	}

	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
	}

	@Override
    public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
