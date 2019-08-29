package ZDemo03_offcn0828servlet.dao.impl;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import ZDemo03_offcn0828servlet.bean.Student;
import ZDemo03_offcn0828servlet.dao.StudentDao;
import ZDemo03_offcn0828servlet.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;


public class StudentDaoImpl implements StudentDao {

	@Override
    public int insertStudent(Student stu) {
		
		int result = 0;
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "insert into student values(null,?,?,?,?)";
		
		String course = "";
		
		if(stu.getCourse()!=null){
			for(String str:stu.getCourse()){
				course=course+str+"#";
			}
		}
		
		try {
			result = qr.update(sql, new Object[]{stu.getName(),stu.getAge(),stu.getBirthday(),course});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@Override
    public List<Student> findAllStudent(){
		
		List<Student> result = new ArrayList<Student> ();
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from student";
		try {
			
			List<Map<String,Object>> list = qr.query(sql, new MapListHandler());
			
			for(Map<String,Object> map:list){
				
				Student stu = new Student();
				
				for(Map.Entry<String,Object> entry:map.entrySet()){
					
					if("id".equals(entry.getKey())){
						stu.setId((int)entry.getValue());
					}else if("name".equals(entry.getKey())){
						stu.setName((String)entry.getValue());
					}else if("age".equals(entry.getKey())){
						stu.setAge((int)entry.getValue());
					}else if("birthday".endsWith(entry.getKey())){
						stu.setBirthday((Date)entry.getValue());
					}else if("course".equals(entry.getKey())){
						String str = (String)entry.getValue();
						if(str!="" && str!=null){
							str = str.substring(0,str.length()-1);
							String[] ss = str.split("#");
							stu.setCourse(ss);
						}
					}
				}
				
				result.add(stu);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
}
