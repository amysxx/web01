package servlet;


import utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.TimeZone;


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
        this.doPost (request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType ("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter ( );
        out.print ("您上次访问时间是：");

        //获得用户的时间cookie
        Cookie cookies[] = request.getCookies ( );
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if (cookies[i].getName ( ).equals ("lastAccessTime2")) {
                long cookieValue = Long.parseLong (cookies[i].getValue ( ));       //得到用户的上次访问时间
                Date date = new Date (cookieValue);                      //将long转换为日期
                out.print (date.toString ());
            }
        }

        //给用户会送最新的访问时间
        Cookie cookie = new Cookie ("lastAccessTime2", System.currentTimeMillis () + "");
        cookie.setMaxAge (1 * 30 * 24 * 3600);            //上次访问时间数据存留一个月
        //cookie.setPath ("/");                           //设置路径

        //显示Java能识别的系统中所有正确的时区
        String[] ids = TimeZone.getAvailableIDs();
        for(int i = 0; i < ids.length; i++) {
            System.out.println(ids[i].toString());
        }
        response.addCookie (cookie);

    }
}
