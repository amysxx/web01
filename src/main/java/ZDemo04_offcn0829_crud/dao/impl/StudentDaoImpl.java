package ZDemo04_offcn0829_crud.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import ZDemo04_offcn0829_crud.bean.Student;
import ZDemo04_offcn0829_crud.dao.StudentDao;
import ZDemo04_offcn0829_crud.utils.C3P0Utils;
import ZDemo04_offcn0829_crud.utils.DateUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
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
		
		List<Student> result = new ArrayList<Student>();
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from student order by id desc";
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


	@Override
	public Student findStudentById(int id) {
		
		Student stu = new Student();
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from student where id=?";
		
	    try {
			Map<String,Object> map = qr.query(sql, new MapHandler(),id);
			
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}


	@Override
	public int updateStudent(Student stu) {
		
        int result = 0;
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "update student set name=?,age=?,birthday=?,course=? where id=?";
		
		String course = "";
		
		if(stu.getCourse()!=null){
			for(String str:stu.getCourse()){
				course=course+str+"#";
			}
		}
		
		try {
			result = qr.update(sql, new Object[]{stu.getName(),stu.getAge(),stu.getBirthday(),course,stu.getId()});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public int deleteStudentById(int id) {
        int result = 0;
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "delete from student where id=?";
		
		try {
			result = qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public List<Student> findStudentByCondition(Student s) {
		
		List<Student> result = new ArrayList<Student>();
		
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		//String sql = "select * from student where name like ? and age = ? and birthday=? and course=?";
		String sql = this.getSQL(s);
		System.out.println(sql+"<<<<");
		
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
	
	public String getSQL(Student stu){
		
		StringBuilder sb = new StringBuilder("select * from student where 1=1");
		
		if(stu.getName()!=null && !"".equals(stu.getName())){
			
			sb.append(" and name like '%").append(stu.getName()).append("%'");
		}
		
		if(stu.getAge()!=0){
			sb.append(" and age=").append(stu.getAge());
		}
		/*
		if(stu.getBirthday()!=null && !"".equals(stu.getBirthday())){
			sb.append(" and birthday='").append(DateUtil.dateToString(stu.getBirthday())).append("'");
		}*/
		if(stu.getBirthday()!=null && !"".equals(stu.getBirthday())){
			sb.append(" and birthday='").append(DateUtil.dateToString(stu.getBirthday())).append("'");
		}
		
		if(stu.getCourse()!=null && stu.getCourse().length>0){
			
			String course = "";
			for(String str:stu.getCourse()){
				course=course+str+"#";
			}
			sb.append(" and course='").append(course).append("'");
		}
		
		return sb.toString();
	}
	
}
