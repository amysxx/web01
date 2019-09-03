package dao;

import bean.Student;

import java.util.List;

/**
 * @author amy
 * @date 2019/8/29 14:21
 */
public interface StudentDao {
    int add(Student student);

    List<Student> findAllStudent();

    int delete(int id);

    Student query(int id);

    int update(Student stu,int id);
}