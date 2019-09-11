package ajax.dao.impl;

import ajax.bean.Product;
import ajax.dao.ProductDao;
import ajax.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;


public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findProductByName(String name) {
		
		System.out.println(name+"<<<<");
		
		List<Product> list = null;
		
		if(!"".equals(name)){
			
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			String sql = "select * from product where name like ?";
			
			try {
				list = qr.query(sql,new BeanListHandler<>(Product.class),"%"+name+"%");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
