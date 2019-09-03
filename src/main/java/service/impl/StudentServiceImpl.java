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

    @Override
    public int delete(int id) {
        return studentDao.delete(id);
    }

    @Override
    public Student query(int id) {
        return studentDao.query(id);
    }

    @Override
    public int update(Student stu, int id) {
        return studentDao.update (stu,id);
    }
}
