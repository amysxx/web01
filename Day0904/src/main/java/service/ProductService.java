package service;

import bean.Product;

import java.util.List;

public interface ProductService {
	
	public int addProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public int removeProductById(int id);
	
	public int removeBatch(String ids);
	
	public Product getProductById(int id);
	
	public int modifyProduct(Product product);

}
