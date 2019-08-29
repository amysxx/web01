package ZDemo01_offcn0827servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
@WebServlet("/RespTest3Servlet")
public class RespTest3Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setCharacterEncoding("UTF-8");  // 设置数据存入数组缓冲区中时的编码方式
        response.addHeader("Content-Type", "text/html;charset=utf-8"); // 设置浏览器查看时的编码方式
        //response.setContentType("text/html;charset=utf-8");
		OutputStream os = response.getOutputStream();
		String str = "中公教育";
		os.write(str.getBytes("utf-8"));

		/*response.setContentType("text/html;charset=utf-8");
		OutputStream os = response.getOutputStream();
		String str = "中公教育";
		os.write(str.getBytes());*/
		
	}

}
