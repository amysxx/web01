package service.impl;

import bean.Student;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import service.StudentService;

import java.util.List;

/**
 * @author amy
 * @date 2019/8/29 14:17
 */
public class StudentServiceImpl implements StudentService {

    StudentDao studentDao = new StudentDaoImpl ();
    @Override
    public int add(Student student) {
        return studentDao.add(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDao.findAllStudent();
    }
}
