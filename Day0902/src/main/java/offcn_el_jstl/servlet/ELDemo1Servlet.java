package offcn_el_jstl.servlet;

import offcn_el_jstl.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/ELDemo1Servlet")
public class ELDemo1Servlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("requestKey","requestValue-中公教育");
		request.getSession().setAttribute("sessionKey","sessionValue-优就业");
		this.getServletContext().setAttribute("scKey","scValue");


		Student stu = new Student(1,"张三",22);
		request.setAttribute("stu",stu);


		List<String> list = new ArrayList<String>();
		list.add("xxx");
		list.add("yyy");
		list.add("zzz");

		request.setAttribute("stringList", list);


		Student stu2 = new Student(2,"李四",23);
		Student stu3 = new Student(3,"王五",24);
		List<Student> stuList = new ArrayList<>();
		stuList.add(stu);
		stuList.add(stu2);
		stuList.add(stu3);

		request.setAttribute("stuList",stuList);


		Map<String,String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc-c", "333");

		request.setAttribute("map",map);
		
		
		request.getRequestDispatcher("el.jsp").forward(request, response);
	}

}
