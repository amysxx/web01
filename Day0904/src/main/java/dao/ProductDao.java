package dao;

import bean.Product;

import java.util.List;

public interface ProductDao {
	
	public int insertProduct(Product product);
	
	public List<Product> findAllProduct();
	
	public int delProductById(int id);
	
	public int delBatch(String ids);
	
	public Product findProductById(int id);
	
	public int updateProduct(Product product);

}
