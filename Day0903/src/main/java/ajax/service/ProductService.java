package ajax.service;

import ajax.bean.Product;

import java.util.List;



public interface ProductService {
	
	public List<Product> getProductByName(String name);

}
