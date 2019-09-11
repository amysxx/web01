package dao.impl;

import bean.Category;
import bean.Product;
import dao.ProductDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.*;


public class ProductDaoImpl implements ProductDao {

	@Override
	public int insertProduct(Product product) {
		int result = 0;
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into product values(null,?,?,?,?,?,?,?,?,?)";
		
		try {
			result = qr.update(sql,new Object[]{product.getName(),product.getColor(),product.getPrice(),product.getIntroduction(),product.getImage(),product.getState(),product.getVersion(),product.getBirthday(),product.getCategory().getId()});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

    @Override
    public List<Product> findAllProduct() {

        List<Product> result = new ArrayList<Product> ();
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select p.*,c.categoryname from product p,category c where p.category_id=c.id";

        try {
            List<Map<String,Object>> list = qr.query(sql,new MapListHandler ());

            for(Map<String,Object> map:list){

                Product p = new Product();
                Category c = new Category();

                Set<Map.Entry<String,Object>> set = map.entrySet();
                for(Map.Entry<String,Object> entry:set){

                    if("id".equals(entry.getKey())){
                        p.setId((Integer)(entry.getValue()));
                    }else if("name".equals(entry.getKey())){
                        p.setName((String)(entry.getValue()));
                    }else if("color".equals(entry.getKey())){
                        p.setColor((String)(entry.getValue()));
                    }else if("price".equals(entry.getKey())){
                        p.setPrice((Double)(entry.getValue()));
                    }else if("introduction".equals(entry.getKey())){
                        p.setIntroduction((String)(entry.getValue()));
                    }else if("image".equals(entry.getKey())){
                        p.setImage((String)(entry.getValue()));
                    }else if("state".equals(entry.getKey())){
                        p.setState((String)(entry.getValue()));
                    }else if("version".equals(entry.getKey())){
                        p.setVersion((String)(entry.getValue()));
                    }else if("birthday".equals(entry.getKey())){
                        p.setBirthday((Date)(entry.getValue()));
                    }else if("category_id".equals(entry.getKey())){
                        c.setId((Integer)entry.getValue());
                    }else if("categoryname".equals(entry.getKey())){
                        c.setCategoryName((String)entry.getValue());
                    }

                }

                p.setCategory(c);

                result.add(p);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int delProductById(int id) {
        int result = 0;
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "delete from product where id=?";

        try {
            result = qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delBatch(String ids){
        int result = 0;
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = this.getDelBatchSql(ids);

        try {
            result = qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getDelBatchSql(String ids){

        ids = ids.substring(0,ids.length()-1);

        String sql = "delete from product where id in("+ids+")";

        return sql;

    }

    @Override
    public Product findProductById(int id) {

        Product p = new Product();
        Category c = new Category();

        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select p.*,c.categoryname from product p,category c where p.category_id=c.id and p.id=?";

        try {
            Map<String,Object> map = qr.query(sql,new MapHandler (),id);
            Set<Map.Entry<String, Object>> set = map.entrySet();

            for(Map.Entry<String,Object> entry:set){

                if("id".equals(entry.getKey())){
                    p.setId((Integer)(entry.getValue()));
                }else if("name".equals(entry.getKey())){
                    p.setName((String)(entry.getValue()));
                }else if("color".equals(entry.getKey())){
                    p.setColor((String)(entry.getValue()));
                }else if("price".equals(entry.getKey())){
                    p.setPrice((Double)(entry.getValue()));
                }else if("introduction".equals(entry.getKey())){
                    p.setIntroduction((String)(entry.getValue()));
                }else if("image".equals(entry.getKey())){
                    p.setImage((String)(entry.getValue()));
                }else if("state".equals(entry.getKey())){
                    p.setState((String)(entry.getValue()));
                }else if("version".equals(entry.getKey())){
                    p.setVersion((String)(entry.getValue()));
                }else if("birthday".equals(entry.getKey())){
                    p.setBirthday((Date)(entry.getValue()));
                }else if("category_id".equals(entry.getKey())){
                    c.setId((Integer)entry.getValue());
                }else if("categoryname".equals(entry.getKey())){
                    c.setCategoryName((String)entry.getValue());
                }
            }

            p.setCategory(c);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    @Override
    public int updateProduct(Product product) {

        int result = 0;
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql = "";
        Object[] objs= null;

        if(product.getImage()!=null && !"".equals(product.getImage())){

            sql="update product set name=?,color=?,price=?,introduction=?,image=?,state=?,version=?,birthday=?,category_id=? where id=?";
            objs = new Object[]{product.getName(),product.getColor(),product.getPrice(),product.getIntroduction(),product.getImage(),product.getState(),product.getVersion(),product.getBirthday(),product.getCategory().getId(),product.getId()};
        }else{

            sql="update product set name=?,color=?,price=?,introduction=?,state=?,version=?,birthday=?,category_id=? where id=?";
            objs = new Object[]{product.getName(),product.getColor(),product.getPrice(),product.getIntroduction(),product.getState(),product.getVersion(),product.getBirthday(),product.getCategory().getId(),product.getId()};
        }

        try {
            result = qr.update(sql,objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
