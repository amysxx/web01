package com.offcn.spring;

import com.offcn.spring.controller.UserController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //加载spring IoC配置文件
        //ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
       //获取控制器对象
        UserController bean = context.getBean(UserController.class);//ctrl + alt + v
        //调用控制器方法
        bean.execute();
        //关闭ioc容器
        context.close();

    }
}
