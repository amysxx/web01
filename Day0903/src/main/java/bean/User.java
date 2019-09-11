package bean;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;



public class User implements Serializable, HttpSessionActivationListener {
	
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		
		System.out.println("session被活化时执行<<<>>>");
		
	}
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		
		System.out.println("session被钝化时执行<<<>>>");
		
	}

}
