package service;

import bean.Student;

import java.util.List;

/**
 * @author amy
 * @date 2019/8/29 14:17
 */
public interface StudentService {
    int add(Student student);

    List<Student> getAllStudent();

    int delete(int id);

    Student query(int id);

    int update(Student stu,int id);
}
