package dao.impl;

import bean.Category;
import dao.CategoryDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;



public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> findAllCategory() {
		List<Category> list = null;
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from category";
		
		try {
			list = qr.query(sql,new BeanListHandler<>(Category.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
