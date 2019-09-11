package ajax.servlet;

import ajax.bean.City;
import ajax.bean.Country;
import ajax.service.CityService;
import ajax.service.CountryService;
import ajax.service.impl.CityServiceImpl;
import ajax.service.impl.CountryServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/0903/TestServlet")
public class TestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fun = request.getParameter("fun");
		
		if("findAllCountry".equals(fun)){
			findAllCountry(request,response);
		}else if("findCityByCountryId".equals(fun)){
			findCityByCountryId(request,response);
		}	
	}
	
	protected void findCityByCountryId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String countryId = request.getParameter("countryId");
		
		CityService service = new CityServiceImpl ();
		List<City> list = service.getCityByCountryId(Integer.parseInt(countryId));
		
		JSONObject json = new JSONObject();
		json.put("cityList", JSONArray.fromObject(list));
		out.print(json.toString());
		System.out.println(json.toString());
		
		out.flush();
		out.close();
	}
	
	
	protected void findAllCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		CountryService service = new CountryServiceImpl ();
		List<Country> list = service.getAllCountry();
		
		//JSON   GSON   Jackson
	/*
		JSONArray jsonArr = JSONArray.fromObject(list);
		String str1 = jsonArr.toString();
		System.out.println(str1+"<<<>>>");
	*/
		JSONObject json = new JSONObject();
		json.put("countryList", JSONArray.fromObject(list));
		out.print(json.toString());
		System.out.println(json.toString());
		
		out.flush();
		out.close();
	}

}
