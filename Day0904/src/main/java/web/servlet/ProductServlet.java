package web.servlet;

import bean.Category;
import bean.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.ProductService;
import service.impl.ProductServiceImpl;
import utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	//处理带文件上传的表单
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //fileupload jar包中的方法
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
	   
		Product product = new Product();
		
		try {
			List<FileItem> list = sfu.parseRequest(request);  //所有表单项都存在list中
			//但，type="file" 的 表单项和  其他表单项的处理方式不同！！！
			for(FileItem item:list){
				
				if(item.isFormField()){  // 是普通表单项——把表单项的值存到一个Product的对象中
					
					//既要得到表单项的value，又要得到表单项name
					
					String name = item.getFieldName();
					String value= item.getString("UTF-8");
					
					if("cid".equals(name)){
						Category c = new Category();
						c.setId(Integer.parseInt(value));
						product.setCategory(c);
					}else if("pname".equals(name)){
						product.setName(value);
					}else if("color".equals(name)){
						product.setColor(value);
					}else if("price".equals(name)){
						product.setPrice(Double.parseDouble(value));
					}else if("description".equals(name)){
						product.setIntroduction(value);
					}else if("state".equals(name)){
						product.setState(value);
					}else if("version".equals(name)){
						product.setVersion(value);
					}else if("product_date".equals(name)){
						product.setBirthday(DateUtil.stringToDate(value));
					}
					
				}else{  // type="file"的表单项——文件上传
					String name = item.getName(); // 获得选择文件的文件名
					
				/*	
					InputStream is = item.getInputStream();
					String folderPath = this.getServletContext().getRealPath("/upload");
					OutputStream os = new FileOutputStream(folderPath+"/"+name);
					*/
					
					//截取后缀名

					String suffix = name.substring(name.lastIndexOf("."));
					String filename = UUID.randomUUID().toString().replaceAll("-","")+suffix;
					InputStream is = item.getInputStream();
					String folderPath = this.getServletContext().getRealPath("/upload");
					OutputStream os = new FileOutputStream (folderPath+"/"+filename);
					
					byte[] b = new byte[1024];
					int len = 0;
					while((len=is.read(b))!=-1){
						os.write(b, 0, len);
					}
					
					is.close();
					os.close();
					product.setImage(filename);
				}
				
			}
			
		} catch (FileUploadException e) {
			
			e.printStackTrace();
		}
		
		
		ProductService service = new ProductServiceImpl ();
		
		int result = service.addProduct(product);
		
		if(result!=0){
			System.out.println("成功！！！");
		}else {
            System.out.println ("失败!!!" );
        }
		
		
	}

}
