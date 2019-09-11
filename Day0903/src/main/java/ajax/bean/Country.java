package ajax.bean;

import java.util.ArrayList;
import java.util.List;

public class Country {
	
	private int id;
	private String name;
	private List<City> cityList = new ArrayList<City>();
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
	public List<City> getCityList() {
		return cityList;
	}
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

}
