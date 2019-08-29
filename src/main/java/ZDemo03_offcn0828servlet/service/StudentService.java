package ZDemo03_offcn0828servlet.service;

import ZDemo03_offcn0828servlet.bean.Student;

import java.util.List;


public interface StudentService {
	
	public int addStudent(Student stu);

	public List<Student> getAllStudent();
}
