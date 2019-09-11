package web.servlet;

import bean.Category;
import net.sf.json.JSONArray;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fun = request.getParameter("fun");;
		if("findall".equals(fun)){
			findall(request,response);
		}
	}
	
	protected void findall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		CategoryService service = new CategoryServiceImpl ();
		List<Category> list = service.getAllCategory();
		
		JSONArray json = JSONArray.fromObject(list);
		
		out.print(json.toString());
		
		
		out.flush();
		out.close();
	}

}
