package bean;


import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Student implements HttpSessionBindingListener {

	private int id;
	private String name;
	private int age;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		
		System.out.println("Student对象被存到session中时执行####");
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		
		System.out.println("Student对象被从session中移除时执行");
	}

}
