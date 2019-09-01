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
 * @date 2019/8/26 19:52
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //乱码第一种解决
        request.setCharacterEncoding ("UTF-8");

        String username = request.getParameter ("username");
        //乱码第二种解决  username = new String(username.getBytes (("ISO_8859_1")),"UTF-8");
        //乱码 第三种解决   <Connector URIEncoding="UTF-8" connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" />
        String password = request.getParameter ("password");
        //  password = new String(password.getBytes (("ISO_8859_1")),"UTF-8");
        String sex = request.getParameter ("sex");
        //  sex = new String(sex.getBytes (("ISO_8859_1")),"UTF-8");
        String age = request.getParameter ("age");

        User user = new User ( );
        user.setUsername (username);
        user.setPassword (password);
        user.setSex (sex);
        user.setAge (Integer.parseInt (age));
        UserService userService = new UserServiceImpl ( );
        int result = userService.register (user);
        if (result > 0) {
            System.out.println (username );
            System.out.println (password );
            System.out.println (sex );
            System.out.println (age );

            System.out.println ("注册成功");


        } else {
            System.out.println ("注册失败");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost (request, response);
    }
}
