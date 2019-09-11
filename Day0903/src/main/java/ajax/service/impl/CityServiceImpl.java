package ajax.service.impl;

import ajax.bean.City;
import ajax.dao.CityDao;
import ajax.dao.impl.CityDaoImpl;
import ajax.service.CityService;

import java.util.List;



public class CityServiceImpl implements CityService {

	CityDao dao = new CityDaoImpl ();
	
	@Override
    public List<City> getCityByCountryId(int id) {
		
		return dao.findCityByCountryId(id);
	}

}
