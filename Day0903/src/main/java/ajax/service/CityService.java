package ajax.service;

import ajax.bean.City;

import java.util.List;



public interface CityService {
	
	public List<City> getCityByCountryId(int id);

}
