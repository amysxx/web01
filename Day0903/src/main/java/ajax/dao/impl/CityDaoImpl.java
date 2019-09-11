package ajax.dao.impl;

import ajax.bean.City;
import ajax.dao.CityDao;
import ajax.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;



public class CityDaoImpl implements CityDao {

	@Override
	public List<City> findCityByCountryId(int id) {
		
		List<City> list = null;
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "select * from city where country_id=?";
		
		try {
			list = qr.query(sql,new BeanListHandler<> (City.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
