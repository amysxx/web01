package ZDemo04_offcn0830session.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author amy
 * @date 2019/9/1 0:44
 */
@WebServlet("/SessionDemo01Servlet")
public class SessionDemo01Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet (request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = "";
        HttpSession session = request.getSession(false);
        if(session==null){
            str = "第一次访问";
            session = request.getSession();
        }else{
            str = "欢迎回来";
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");

        out.println(str);
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
