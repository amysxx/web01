package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author amy
 * @date 2019/8/27 19:50
 */
@WebServlet("/showServlet")
public class showServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType ("text/html;charset=utf-8");
        /*
        一个相应体中不能同时存在两种流
         */
        PrintWriter out = response.getWriter ();
        //ServletOutputStream sos =response.getOutputStream ();
        int num = (int) this.getServletContext ().getAttribute ("num");

        out.print("<h1>您是第"+num+"位登录成功的用户</h1>");
        out.print ("<a href=\"download/amy.txt\">下载amy.txt</a>\n" +
                "<a href=\"download/01.jpg\">下载01.jpg</a>\n" +
                "<a href=\"download/01.zip\">下载01.zip</a>\n");
        out.print("<a href=\"downloadServlet?filename=amy.txt\">下载amy.txt</a>\n" +
                "<a href=\"downloadServlet?filename=01.jpg\">下载01.jpg</a>\n" +
                "<a href=\"downloadServlet?filename=01.zip\">下载01.zip</a>\n" +
                "<a href=\"downloadServlet?filename=中文.txt\">下载-中文.txt</a>");

        out.flush();
        out.close();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost (request,response);
    }
}
