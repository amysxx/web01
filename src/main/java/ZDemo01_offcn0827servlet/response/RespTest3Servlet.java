package ZDemo01_offcn0827servlet.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class RespTest3Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		OutputStream os = response.getOutputStream();
		String str = "中公教育";
		os.write(str.getBytes("gbk"));
		*/
		
		response.setContentType("text/html;charset=utf-8");
		OutputStream os = response.getOutputStream();
		String str = "中公教育";
		os.write(str.getBytes());
		
	}

}
