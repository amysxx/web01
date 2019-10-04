/**
 * @author amy
 * @date 2019/10/3 3:31
 */
public class test_06_valatileVisibility {
    private static volatile boolean initFlag = false;

    public static void main(String[] args) throws Exception {
        new Thread (() -> {
            System.out.println ("waiting data..." );
            while(!initFlag){
            }
            System.out.println ("=========success" );
        }).start ();

        Thread.sleep (2000);

        new Thread (() -> {
        prepareData();
        }).start ();
    }

    private static void prepareData() {
        System.out.println ("prepateData...start" );
        initFlag = true;
        System.out.println ("prepareDate...end" );
    }
}
