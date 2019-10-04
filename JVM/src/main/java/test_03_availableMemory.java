import java.util.Random;

/**
 * @author amy
 * @date 2019/10/2 13:08
 */
public class test_03_availableMemory {
    public static void main(String[] args) {
        //返回虚拟机视图使用的最大内存总量
        System.out.println (Runtime.getRuntime ( ).maxMemory ( ) / 1024 / 1024 + "M");
        //返回虚拟机分配的内存总量
        System.out.println (Runtime.getRuntime ( ).maxMemory ( ) / 1024 / 1024 + "M");

        String str = "hello world!";
        while (true){
            str =str +new Random ().nextInt (888888888)+new Random ().nextInt (999999999);
        }
    }
}
