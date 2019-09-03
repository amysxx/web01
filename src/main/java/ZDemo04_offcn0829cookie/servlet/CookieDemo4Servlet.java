package ZDemo04_offcn0829cookie.servlet;

import ZDemo04_offcn0829cookie.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;


/*
 * 使用Cookie记录客户端上次访问的时间
 * 
 * 思路：
 *     访问时获取想要的Cookie 如果没有获取到说明是第一次访问，把当前时间存到一个Cookie中响应给客户端    
 *     如果获取到了，从cookie中取时间（上次访问时间），再把当前时间存入Cookie中
 * 
 * */
@WebServlet("/CookieDemo4Servlet")
public class CookieDemo4Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Cookie[] cs = request.getCookies();

        Cookie c = CookieUtils.findCookieByName("lasttime", cs);

		/*if(cs!=null){

			for(Cookie cc:cs){

				if(cc.getName().equals("lasttime")){
					c = cc;
					break;
				}
			}
		}*/

        if(c!=null){
            out.print("<h1>上次访问时间为："+URLDecoder.decode (c.getValue (),"UTF-8")+"</h1>");
        }else{  //第一次访问
            out.print("<h1>欢迎第一次访问</h1>");
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern ("yyyy-MM-dd hh:mm:ss");
        String date =LocalDateTime.now ().format (dtf);

        Cookie cookie = new Cookie("lasttime", URLEncoder.encode (date,"UTF-8"));
        cookie.setMaxAge(60*20*24);
        cookie.setPath ("/");
        response.addCookie(cookie);

    }

}