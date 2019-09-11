package ajax.service.impl;

import ajax.bean.Country;
import ajax.dao.CountryDao;
import ajax.dao.impl.CountryDaoImpl;
import ajax.service.CountryService;

import java.util.List;


public class CountryServiceImpl implements CountryService {

	CountryDao dao = new CountryDaoImpl ();
	@Override
    public List<Country> getAllCountry() {
		return dao.findAllCountry();
	}

}
