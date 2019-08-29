package ZDemo03_offcn0828servlet.dao;


import ZDemo03_offcn0828servlet.bean.Student;

import java.util.List;

public interface StudentDao {
	
	public int insertStudent(Student stu);
	
	public List<Student> findAllStudent();

}
