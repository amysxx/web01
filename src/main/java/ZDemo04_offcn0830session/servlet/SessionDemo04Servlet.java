package ZDemo04_offcn0830session.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author amy
 * @date 2019/9/4 3:28
 */
@WebServlet("/SessionDemo04Servlet")
public class SessionDemo04Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet (request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println (request.getAttribute ("reqKey") );
        System.out.println (request.getSession ().getAttribute ("sesKey") );
        System.out.println (this.getServletContext ().getAttribute ("scKey") );
    }
}
