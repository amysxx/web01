package ajax.servlet;

import ajax.bean.Product;
import ajax.service.ProductService;
import ajax.service.impl.ProductServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/0903/ProductServlet")
public class ProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String word = request.getParameter("word");
		ProductService service = new ProductServiceImpl ();
		List<Product> list = service.getProductByName(word);
        System.out.println (word);
		if(list!=null){
			JSONArray json = JSONArray.fromObject(list);
			out.print(json.toString());
			System.out.println(json.toString());
		}else{
			System.out.println("#################");
			out.print("");
		}
		
		out.flush();
		out.close();
	}

}
