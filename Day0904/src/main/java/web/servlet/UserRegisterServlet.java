package web.servlet;

import bean.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.MyDateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;


@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fun  =request.getParameter("fun");
        if("checkUsername".equals(fun)){
            checkUsername(request,response);
        }else if("addUser".equals (fun)){
            addUser (request,response);
        }

	}
    protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> map =request.getParameterMap();
        User user = new User();

        MyDateConverter converter = new MyDateConverter();
        ConvertUtils.register(converter, Date.class);

        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        UserService service = new UserServiceImpl ();

        int result = service.addUser(user);

        if(result!=0){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }


    }
    protected void checkUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        UserService service = new UserServiceImpl ();
        User user = service.getUserByUsername(username);

        if(user==null){
            out.print("yes");
        }else{
            out.print("no");
        }
        out.flush();
        out.close();

    }

}
