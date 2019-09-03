package bean;


import java.util.Arrays;
import java.util.Date;

/**
 * @author amy
 * @date 2019/8/29 13:52
 */
public class Student {

    private int id;
    private String name;
    private int age;
    private Date birthday;
    private String[] course;

    public Student() {
    }

    public Student(int id, String name, int age, Date birthday, String[] course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.course = course;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String[] getCourse() {
        return course;
    }
    public void setCourse(String[] course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", course=" + Arrays.toString (course) +
                '}';
    }
}
