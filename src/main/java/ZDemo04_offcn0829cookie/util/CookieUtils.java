package ZDemo04_offcn0829cookie.util;

import javax.servlet.http.Cookie;

public class CookieUtils {
	
	public static Cookie findCookieByName(String name,Cookie[] cs){
		
		if(cs!=null){
			for(Cookie c:cs){
				if(name.equals(c.getName())){
					return c;
				}
			}
		}
		return null;
	}
}
