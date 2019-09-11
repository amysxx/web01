package service.impl;

import bean.Category;
import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import service.CategoryService;

import java.util.List;



public class CategoryServiceImpl implements CategoryService {

	CategoryDao dao = new CategoryDaoImpl ();
			
	public List<Category> getAllCategory() {
		
		return dao.findAllCategory();
	}

}
