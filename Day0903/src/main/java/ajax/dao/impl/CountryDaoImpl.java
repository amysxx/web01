package ajax.dao.impl;


import ajax.bean.Country;
import ajax.dao.CountryDao;
import ajax.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CountryDaoImpl implements CountryDao {

	public List<Country> findAllCountry() {
		
		List<Country> list = null;
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from country";
		
		try {
			list = qr.query(sql,new BeanListHandler<> (Country.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
