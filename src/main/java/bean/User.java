package bean;

/**
 * @author amy
 * @date 2019/8/26 18:19
 * <p>
 * create table user(
 * id int(11) primary key not null auto_increment,
 * username varchar(255),
 * password varchar(255),
 * sex varchar(255),
 * age int(11)
 * )
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String sex;
    private int age;

    public User() {
    }

    public User(int id, String username, String password, String sex, int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
