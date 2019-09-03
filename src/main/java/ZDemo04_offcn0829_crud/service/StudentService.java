package ZDemo04_offcn0829_crud.service;

import ZDemo04_offcn0829_crud.bean.Student;

import java.util.List;



public interface StudentService {
	
	public int addStudent(Student stu);

	public List<Student> getAllStudent();
	
	public Student getStudentById(int id);
	
	public int modifyStudent(Student stu);
	
	public int removeStudentById(int id);
	
	public List<Student> getStudentByCondition(Student stu);
}
