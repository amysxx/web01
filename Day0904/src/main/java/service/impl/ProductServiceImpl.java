package service.impl;


import bean.Product;
import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import service.ProductService;

import java.util.List;


public class ProductServiceImpl implements ProductService {

    ProductDao dao = new ProductDaoImpl();

    @Override
    public int addProduct(Product product) {

        return dao.insertProduct(product);
    }

    @Override
    public List<Product> getAllProduct() {

        return dao.findAllProduct();
    }

    @Override
    public int removeProductById(int id) {

        return dao.delProductById(id);
    }

    @Override
    public int removeBatch(String ids) {

        return dao.delBatch(ids);
    }

    @Override
    public Product getProductById(int id) {

        return dao.findProductById(id);
    }

    @Override
    public int modifyProduct(Product product) {

        return dao.updateProduct(product);
    }

}
