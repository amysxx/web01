package ZDemo04_offcn0829_crud.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ZDemo04_offcn0829_crud.bean.Student;
import ZDemo04_offcn0829_crud.service.StudentService;
import ZDemo04_offcn0829_crud.service.impl.StudentServiceImpl;
import ZDemo04_offcn0829_crud.utils.MyDateConverter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;





public class StudentServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); //解决POST请求的乱码问题
		
		String fun = request.getParameter("fun");
		
		if("add".equals(fun)){
			
			add(request,response);
		}else if("findAll".equals(fun)){
			findAll(request,response);
		}else if("preModify".equals(fun)){
			preModify(request,response);
		}else if("modify".equals(fun)){
			modify(request,response);
		}
		else if("remove".equals(fun)){
			remove(request,response);
		}else if("findByCondition".equals(fun)){
			findByCondition(request,response);
		}
		
	}

protected void findByCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	       //1 获取数据（客户端提交的数据） BeanUtils
			Map<String,String[]> map =request.getParameterMap();
			
			//2 对象
			Student stu = new Student();
			
			
			//3 先处理日期类型
		/*	
			DateConverter dc = new DateConverter();
			dc.setPatterns(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"});
			ConvertUtils.register(dc,Date.class);
			*/
			// 如果使用BeanUtils中自带的日期类型转换器DateConverter 对于 null 或 "" 拷贝时会出现异常
			// 解决方式：自定义日期类型转换器
			ConvertUtils.register(new MyDateConverter (),Date.class);
			
			
			// 4 拷贝
			try {
				BeanUtils.populate(stu,map);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			// 5 调用service
			StudentService service = new StudentServiceImpl();
			
			List<Student> list = service.getStudentByCondition(stu);
			
			request.setAttribute("list",list);
			
			request.getRequestDispatcher("viewstudent.jsp").forward(request, response);
			
	
}
	
protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	String id = request.getParameter("id");
	
	StudentService service = new StudentServiceImpl();
	
	int result = service.removeStudentById(Integer.parseInt(id));
	
	if(result!=0){  // 删除成功
		
		response.sendRedirect("StudentServlet?fun=findAll&msg=success");
		
	}else{  //更新失败
		
		response.sendRedirect("StudentServlet?fun=findAll&msg=fail");
	}
	
}
	
protected void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//1 获取数据（客户端提交的数据） BeanUtils
		Map<String,String[]> map =request.getParameterMap();
		
		//2 对象
		Student stu = new Student();
		
		
		//3 先处理日期类型
		DateConverter dc = new DateConverter();
		dc.setPatterns(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"});
		ConvertUtils.register(dc,Date.class);
		
		
		// 4 拷贝
		try {
			BeanUtils.populate(stu,map);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		// 5 调用service
		StudentService service = new StudentServiceImpl ();
		
		int result = service.modifyStudent(stu);
		
		if(result!=0){  // 更新成功
			
			response.sendRedirect("StudentServlet?fun=findAll&msg=success");
			
		}else{  //更新失败
			
			response.sendRedirect("modifystudent.jsp?msg=fail");
		}
		
	}
	
	
	protected void preModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		StudentService service = new StudentServiceImpl();
		
		Student stu = service.getStudentById(Integer.parseInt(id));
		
		request.setAttribute("stu",stu);
		
		request.getRequestDispatcher("modifystudent.jsp").forward(request, response);
		
	}
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String msg = request.getParameter("msg");
		
		StudentService service = new StudentServiceImpl();
		
		List<Student> list = service.getAllStudent();
		
		request.setAttribute("msg",msg);
		
		request.setAttribute("list",list);
		
		request.getRequestDispatcher("viewstudent.jsp").forward(request,response);
	}
	
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//1 获取数据（客户端提交的数据） BeanUtils
		Map<String,String[]> map =request.getParameterMap();
		//2 对象
		Student stu = new Student();
		
		
		//3 先处理日期类型
		DateConverter dc = new DateConverter();
		dc.setPatterns(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"});
		ConvertUtils.register(dc,Date.class);
		
		
		// 4 拷贝
		try {
			BeanUtils.populate(stu,map);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		// 5 调用service
		StudentService service = new StudentServiceImpl();
		
		int result = service.addStudent(stu);
		
		if(result!=0){  // 添加成功
			
			response.sendRedirect("StudentServlet?fun=findAll&msg=success");
			
		}else{  //添加失败
			//request.setAttribute("msg","添加失败");
			//request.getRequestDispatcher("addstudent.jsp").forward(request, response);
			
			response.sendRedirect("addstudent.jsp?msg=fail");
		}
		
	}

}