package ZDemo03_offcn0828servlet.service.impl;


import ZDemo03_offcn0828servlet.bean.Student;
import ZDemo03_offcn0828servlet.dao.StudentDao;
import ZDemo03_offcn0828servlet.dao.impl.StudentDaoImpl;
import ZDemo03_offcn0828servlet.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

	StudentDao dao = new StudentDaoImpl ();
	@Override
    public int addStudent(Student stu) {
		
		return dao.insertStudent(stu);
	}
	@Override
	public List<Student> getAllStudent() {
		
		return dao.findAllStudent();
	}

}
