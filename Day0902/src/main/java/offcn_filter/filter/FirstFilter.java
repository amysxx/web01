package offcn_filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(value = "/FirstFilter",initParams = {
        @WebInitParam(name = "fname",value = "fvalue")
})

public class FirstFilter implements Filter {
	
	/*
	 * Filter对象在服务器启动时创建
	 * */
	@Override
    public void init(FilterConfig arg0) throws ServletException {
		
		System.out.println(arg0.getInitParameter("fname")); // 获取filter的初始化参数
		
		System.out.println(arg0.getFilterName());  // 获取 <filter-name>中的值
		
		
		//如果要在filter中使用ServletContext 需要使用 FilterConfig去获取
		//this.getServletContext();
		ServletContext sc = arg0.getServletContext();
		
		System.out.println("Filter对象被创建时，自动调用init方法...");
	}


	@Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("过滤器中会反复执行的方法###");
		
		
		//放行
        arg2.doFilter(arg0, arg1);
	}

	/*
	 * 服务器关闭时销毁
	 * */
	@Override
    public void destroy() {
        System.out.println("Filter对象被销毁前，调用destroy方法<<<>>>");
	}

}
