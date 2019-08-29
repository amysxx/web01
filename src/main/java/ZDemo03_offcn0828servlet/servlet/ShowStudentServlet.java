package ZDemo03_offcn0828servlet.servlet;

import ZDemo03_offcn0828servlet.bean.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class ShowStudentServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ShowStudentServlet......................");
		
		List<Student> list = (List<Student>)request.getAttribute("list");
		
	/*	for(Student s:list){
			System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getBirthday()+"\t"+Arrays.toString(s.getCourse()));
		}*/
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<table align='center' border='1px' width='70%'>");
		out.print("<tr><th>ID</th><th>NAME</th><th>AGE</th><th>BIRTHDAY</th><th>COURSE</th></tr>");
		for(Student s:list){
			out.print("<tr><td>"+s.getId()+"</td><td>"+s.getName()+"</td><td>"+s.getAge()+"</td><td>"+s.getBirthday()+"</td><td>"+Arrays.toString(s.getCourse())+"</td></tr>");
		}
		out.print("</table>");
		
		out.flush();
		out.close();
	}

}
