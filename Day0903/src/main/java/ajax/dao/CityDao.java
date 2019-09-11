package ajax.dao;


import ajax.bean.City;

import java.util.List;

public interface CityDao {
	
	public List<City> findCityByCountryId(int id);

}
