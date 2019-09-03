package ZDemo04_offcn0830session.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author amy
 * @date 2019/9/1 1:36
 */
@WebServlet("/SessionDemo02Servlet")
public class SessionDemo02Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet (request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding ("utf-8");
        response.setContentType ("text/html;charset=utf-8");
        PrintWriter out = response.getWriter ( );
        request.getSession ( );  //创建session
        //调用response的encodeURL方法，将自动将JSESSION追加到url后面，如：url;jsessionid=BD111FFC653497E81B702A29B3AC6FE4
        String SessionId=request.getRequestedSessionId();
        System.out.println (SessionId );
        String buyurl = response.encodeURL ("/web01/buy");
        String payurl = response.encodeURL ("/web01/pay");
        out.print ("<a href='" + buyurl + "'>购买</a><br/>");
        out.print ("<a href='" + payurl + "'>结账</a><br/>");

    }
}
