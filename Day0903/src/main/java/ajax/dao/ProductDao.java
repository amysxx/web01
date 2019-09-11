package ajax.dao;

import ajax.bean.Product;

import java.util.List;



public interface ProductDao {
	
	public List<Product> findProductByName(String name);

}
