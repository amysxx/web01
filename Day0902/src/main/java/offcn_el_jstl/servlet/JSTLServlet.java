package offcn_el_jstl.servlet;

import offcn_el_jstl.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@WebServlet("/JSTLServlet")
public class JSTLServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
	}


	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<String> list = new ArrayList<String>();
		list.add("xxx");
		list.add("yyy");
		list.add("zzz");

		request.setAttribute("stringList", list);

		Student stu = new Student(1,"张三",16);
		request.setAttribute("stu", stu);


		Student stu2 = new Student(2,"李四",23);
		Student stu3 = new Student(3,"王五",24);
		List<Student> stuList = new ArrayList<>();
		stuList.add(stu);
		stuList.add(stu2);
		stuList.add(stu3);
		request.setAttribute("stuList",stuList);

		int[] aa = {100,200,300,400};
		request.setAttribute("aa",aa);

		Student[] stus = {stu,stu2,stu3};
		request.setAttribute("stus", stus);



		Map<String,String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc-c", "333");
		request.setAttribute("map",map);

		Map<String,Student> stuMap = new HashMap<>();
		stuMap.put("s1", stu);
		stuMap.put("s2", stu2);
		stuMap.put("s3", stu3);
		request.setAttribute("stuMap", stuMap);

		request.setAttribute("now",new Date());

		request.getRequestDispatcher("jstl.jsp").forward(request,response);

	}

}
