package web.servlet;

import bean.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/FindProductServlet")
public class FindProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductService service = new ProductServiceImpl ();
		List<Product> list = service.getAllProduct();
		request.setAttribute("list",list);
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
	}
}
