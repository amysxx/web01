/**
 * @author amy
 * @date 2019/10/1 19:39
 */
public class test_01_traceClassLoading {
    public static void main(String[] args) {
        System.out.println (B.str2 );
    }
}

class A{
    public static String str = "i am A";
    static {
        System.out.println ("i am static code block A" );
    }
}

class B extends A{
    public static String str2 = "i am B";
    static {
        System.out.println ("i am static code block B" );
    }
}