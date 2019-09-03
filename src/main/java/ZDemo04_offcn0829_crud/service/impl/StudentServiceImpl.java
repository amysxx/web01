package ZDemo04_offcn0829_crud.service.impl;

import ZDemo04_offcn0829_crud.bean.Student;
import ZDemo04_offcn0829_crud.dao.StudentDao;
import ZDemo04_offcn0829_crud.dao.impl.StudentDaoImpl;
import ZDemo04_offcn0829_crud.service.StudentService;

import java.util.List;



public class StudentServiceImpl implements StudentService {

	StudentDao dao = new StudentDaoImpl ();
	public int addStudent(Student stu) {
		return dao.insertStudent(stu);
	}
	@Override
	public List<Student> getAllStudent() {
		
		return dao.findAllStudent();
	}
	@Override
	public Student getStudentById(int id) {
		
		return dao.findStudentById(id);
	}
	
	@Override
	public int modifyStudent(Student stu) {
		
		return dao.updateStudent(stu);
	}
	@Override
	public int removeStudentById(int id) {
		
		return dao.deleteStudentById(id);
	}
	@Override
	public List<Student> getStudentByCondition(Student stu) {
		
		return dao.findStudentByCondition(stu);
	}

}
