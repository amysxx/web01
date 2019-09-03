package servlet;

import bean.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import service.StudentService;
import service.impl.StudentServiceImpl;
import utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author amy
 * @date 2019/8/29 14:06
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet (request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String fun = request.getParameter("fun");

        if("add".equals(fun)){
            add(request,response);
        }if("findAll".equals(fun)){
            findAll(request,response);
        }else if("delete".equals (fun)) {
            delete (request, response);
        }else if("query".equals (fun)){
            query (request,response);
        }else if("update".equals (fun)){
            update (request,response);
        }
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter ("name");
        String age = request.getParameter ("age");
        String birthday = request.getParameter ("birthday");

        /*System.out.println (name);
        System.out.println (age);
        System.out.println (birthday);
        Student student = new Student();
*/
        /*student.setName (name);
        student.setAge (Integer.parseInt (age));
        student.setBirthday (DateUtil.stringToDate (birthday));
        System.out.println (student.toString () );*/

        Map<String,String[]> map = request.getParameterMap();

        Student stu = new Student();

        try {
            // 要想完成日期类型的拷贝 需要配置转换器  DateConverter
            DateConverter converter = new DateConverter();
            converter.setPatterns(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"});
            ConvertUtils.register(converter, Date.class);

            BeanUtils.populate(stu,map);  // 完成属性的拷贝.要求：map中的可以 必须和实体类中的set方法对应
        } catch (IllegalAccessException e) {
            e.printStackTrace ( );
        } catch (InvocationTargetException e) {
            e.printStackTrace ( );
        }
        System.out.println (stu.toString () );
        StudentService studentService = new StudentServiceImpl ( );
        int result = studentService.add (stu);
        if (result != 0) {
           /* System.out.println ("getParameterValues---------:");
            String[] cs = request.getParameterValues ("course"); // 获取到选中的checkbox的value
            for (String str : cs) {
                System.out.println (str);
            }

            System.out.println ("getParameterNames---------:");
            Enumeration<String> es = request.getParameterNames ( );
            while (es.hasMoreElements ( )) {
                System.out.println (es.nextElement ( ));
            }

            System.out.println ("getParameterMap---------:");
            Map<String,String[]> map = request.getParameterMap();

            Set<Map.Entry<String,String[]>> it = map.entrySet();

            for(Map.Entry<String,String[]> entry:it){
                System.out.println(entry.getKey()+"----"+ Arrays.toString(entry.getValue()));
            }*/




            response.sendRedirect ("success.html");
        } else {
            response.sendRedirect ("fail.html");
        }


    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentService service = new StudentServiceImpl ();

        List<Student> list = service.getAllStudent();

        /*for(Student stu : list){
            System.out.println (stu.toString () );
        }
*/
		/*// 使用ServletContext 保存查询回的数据，再跳转到展示数据的资源可行，但不好！ ServletContext是所有Servlet共享的，ServletContext的生命周期过长
		this.getServletContext().setAttribute("list",list);
		response.sendRedirect("ShowStudentServlet");
	    */

        // request 也可以作为作用域     作用域的范围：一次请求（从请求发送开始 到产生响应）
        request.setAttribute("list",list); //request.getAttribute(arg0)
        //response.sendRedirect("ShowStudentServlet");  //重定向
        //request.getRequestDispatcher("ShowStudentServlet").forward(request, response);//请求转发

        request.getRequestDispatcher("viewstudent.jsp").forward(request, response);
        /*
         * 转发和重定向的区别？
         *
         * 1 转发时地址栏不变，重定向地址栏改变
         * 2转发只能转发的本项目的资源，而重定向可以重定向到任何资源
         * 3重定向是两次请求两次响应。转发是一次请求，一次响应
         * 4转发效率高于重定向
         * 5要访问受保护的资源(在WEB-INF下的资源)只能使用转发
         * */

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt (request.getParameter ("id"));
        StudentService studentService = new StudentServiceImpl ();
        int result = studentService.delete(id);
        if(result!=0){
            System.out.println ( "删除成功");
            request.getRequestDispatcher ("success.html").forward (request,response);
        }else{
            System.out.println ("删除失败" );
            request.getRequestDispatcher ("fail.html").forward (request,response);
        }
    }

    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt (request.getParameter ("id"));
        System.out.println (id );
        StudentService studentService = new StudentServiceImpl ();
        Student stu = studentService.query(id);
        request.setAttribute ("stu",stu);
        if(stu!=null){
            request.getRequestDispatcher ("updatestudent.jsp").forward (request,response);
        }else{
            System.out.println (stu.toString () );
            request.getRequestDispatcher ("fail.html").forward (request,response);
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String,String[]> map = request.getParameterMap();
        Student stu = new Student ();
        DateConverter converter = new DateConverter ();
        converter.setPatterns (new String[]{"yyyy-MM-dd","yyyy-MM-dd hh:mm:ss"});
        ConvertUtils.register (converter,Date.class);

        try {

            BeanUtils.populate(stu,map);
            System.out.println (stu.toString () );
            StudentService studentService = new StudentServiceImpl ();
            int result = studentService.update(stu,stu.getId ());
            if(result != 0){

                response.sendRedirect (request.getContextPath ()+"/StudentServlet?fun=findAll");
            }else {
                response.sendRedirect ("fail.html");
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace ( );
        } catch (InvocationTargetException e) {
            e.printStackTrace ( );
        }

    }

}
