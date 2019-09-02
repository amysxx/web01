package Demo02jsp.domain;

/**
 * @author amy
 * @date 2019/9/1 20:21
 */
public class User {
    int id;
    String name;
    double sal;

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

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public User(int id, String name, double sal) {
        this.id = id;
        this.name = name;

        this.sal = sal;
    }
}
