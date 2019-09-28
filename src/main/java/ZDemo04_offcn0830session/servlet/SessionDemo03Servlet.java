package ZDemo04_offcn0830session.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

/**
 * @author amy
 * @date 2019/9/4 2:39
 */
@WebServlet(name = "SessionDemo03Servlet",urlPatterns = "/SessionDemo03Servlet")
public class SessionDemo03Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet (request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute ("reqKey","i am requset ");
        HttpSession session = request.getSession ();

        PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
        ServletConfig config = this.getServletConfig();

        session.setAttribute ("sesKey" ,"i am session");

        this.getServletContext ().setAttribute ("scKey","i am ServletContext");

        String path = response.encodeRedirectURL ("SessionDemo04Servlet");
        response.sendRedirect (path);
       // response.sendRedirect ("SessionDemo04Servlet;jsessionid="+session.getId ());


    }
}
