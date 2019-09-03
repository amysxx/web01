package dao.impl;

import bean.Student;
import dao.StudentDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import utils.C3P0Util;

import java.sql.SQLException;
import java.util.*;

/**
 * @author amy
 * @date 2019/8/29 14:22
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public int add(Student stu) {
        QueryRunner qr = new QueryRunner (C3P0Util.getDataSource ());
        String sql = "insert into student values(null,?,?,?,?)";

        String course = "";

        if(stu.getCourse()!=null){
            for(String str:stu.getCourse()){
                course=course+str+"#";
            }
        }
        int result = 0;
        try {
            result = qr.update(sql, new Object[]{stu.getName(),stu.getAge(),stu.getBirthday(),course});
        } catch (SQLException e) {
            e.printStackTrace ( );
        }
        return result;
    }

    @Override
    public List<Student> findAllStudent() {
        List<Student> result = new ArrayList<Student> ();
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from student";
        try {

            List<Map<String,Object>> list = qr.query(sql, new MapListHandler ());

            for(Map<String,Object> map:list){

                Student stu = new Student();

                for(Map.Entry<String,Object> entry:map.entrySet()){

                    if("id".equals(entry.getKey())){
                        stu.setId((int)entry.getValue());
                    }else if("name".equals(entry.getKey())){
                        stu.setName((String)entry.getValue());
                    }else if("age".equals(entry.getKey())){
                        stu.setAge((int)entry.getValue());
                    }else if("birthday".endsWith(entry.getKey())){
                        stu.setBirthday((Date)entry.getValue());
                    }else if("course".equals(entry.getKey())){
                        String str = (String)entry.getValue();
                        if(str!="" && str!=null){
                            str = str.substring(0,str.length()-1);
                            String[] ss = str.split("#");
                            stu.setCourse(ss);
                        }
                    }
                }

                result.add(stu);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(int id) {
        QueryRunner qr = new QueryRunner (C3P0Util.getDataSource ());
        String sql = "delete from student where id = ?";
        int result = 0;
        try {
            result = qr.update (sql,new Object[]{id});
        } catch (SQLException e) {
            e.printStackTrace ( );
        }
        return result;
    }

    @Override
    public Student query(int id) {
        QueryRunner qr = new QueryRunner (C3P0Util.getDataSource ());
        String sql = "select * from student where id = ?";
        Student stu = new Student();
        Map<String,Object> map = null;
        try {
            map = qr.query (sql,new MapHandler (),id);
        } catch (SQLException e) {
            e.printStackTrace ( );
        }

            for(Map.Entry<String,Object> entry:map.entrySet()){

                if("id".equals(entry.getKey())){
                    stu.setId((int)entry.getValue());
                }else if("name".equals(entry.getKey())){
                    stu.setName((String)entry.getValue());
                }else if("age".equals(entry.getKey())){
                    stu.setAge((int)entry.getValue());
                }else if("birthday".endsWith(entry.getKey())){
                    stu.setBirthday((Date)entry.getValue());
                }else if("course".equals(entry.getKey())){
                    String str = (String)entry.getValue();
                    if(str!="" && str!=null){
                        str = str.substring(0,str.length()-1);
                        String[] ss = str.split("#");
                        stu.setCourse(ss);
                    }
                }
            }
        return stu;
    }

    @Override
    public int update(Student stu, int id) {
        QueryRunner qr = new QueryRunner (C3P0Util.getDataSource ());
        String sql = "update student set name = ? , age = ? , birthday = ?  , course = ? where id = ?";
        String course = "";

        if(stu.getCourse()!=null){
            for(String str:stu.getCourse()){
                course=course+str+"#";
            }
        }

        int result = 0;
        try {
            result = qr.update (sql,new Object[]{stu.getName (),stu.getAge (),stu.getBirthday (),course,id});
        } catch (SQLException e) {
            e.printStackTrace ( );
        }
        return result;
    }

}
