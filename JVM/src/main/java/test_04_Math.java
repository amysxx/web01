/**
 * @author amy
 * @date 2019/10/2 18:41
 */
public class test_04_Math {
    public static final Integer CONSTANT = 666;

    public int compute() { //一个方法对应一个栈帧
        int a = 1;
        int b = 2;
        int c = (a+b)*10;
        return c;
    }

    public static void main(String[] args) {
        test_04_Math test_04_math = new test_04_Math ( );
        test_04_math.compute ();
    }
}
