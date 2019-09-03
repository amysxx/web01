package ZDemo04_offcn0829_crud.dao;

import ZDemo04_offcn0829_crud.bean.Student;

import java.util.List;



public interface StudentDao {
	
	public int insertStudent(Student stu);
	
	public List<Student> findAllStudent();
	
	public Student findStudentById(int id);
	
	public int updateStudent(Student stu);
	
	public int deleteStudentById(int id);
	
	public List<Student> findStudentByCondition(Student stu);

}
