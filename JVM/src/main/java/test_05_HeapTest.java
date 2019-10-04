import java.util.ArrayList;

/**
 * @author amy
 * @date 2019/10/3 0:59
 */
public class test_05_HeapTest {
    byte[] bytes=new byte[1024*1000];
    public static void main(String[] args) throws InterruptedException {
        ArrayList<test_05_HeapTest> arrayList = new ArrayList<> ();
        while (true){
            arrayList.add (new test_05_HeapTest ());
            Thread.sleep (100);
        }

    }
}
