import com.offcn.spring.SpringConfiguration;
import com.offcn.spring.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author amy
 * @date 2019/9/23 10:06
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class App {
    /*public static void main(String[] args) {
        //加载spring IoC配置文件
        //ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        //获取控制器对象
        UserController bean = context.getBean(UserController.class);//ctrl + alt + v
        //调用控制器方法
        bean.execute();
        //关闭ioc容器
        context.close();*/
    @Autowired
    private UserController userController;

    @Test
    public void testUserController() {
        userController.execute ();
    }
}