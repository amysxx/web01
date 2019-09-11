package ajax.service.impl;

import ajax.bean.Product;
import ajax.dao.ProductDao;
import ajax.dao.impl.ProductDaoImpl;
import ajax.service.ProductService;

import java.util.List;



public class ProductServiceImpl implements ProductService {

	ProductDao dao = new ProductDaoImpl ();
	@Override
    public List<Product> getProductByName(String name) {
		return dao.findProductByName(name);
	}

}
