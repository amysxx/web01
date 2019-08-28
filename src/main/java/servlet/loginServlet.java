package servlet;


import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author amy
 * @date 2019/8/27 17:08
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding ("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println (username );
        System.out.println (password );
        UserService userService = new UserServiceImpl ();
        User user = userService.login (username,password);

        if(user!=null){
            int num = 0;
            if(this.getServletContext ().getAttribute ("num")!=null){
                num = (int) this.getServletContext ().getAttribute ("num");
            }

            this.getServletContext ().setAttribute ("num", ++num);

            response.sendRedirect ("showServlet");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost (request,response);
    }
}
