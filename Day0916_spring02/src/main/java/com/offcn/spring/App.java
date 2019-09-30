package com.offcn.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //加载spring IoC配置文件
        //ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext (new String[]{"applicationContext.xml"});

        //从容器中获取bean对象
        Boy boy = (Boy) context.getBean ("boy");
        //Boy boy=context.getBean(Boy.class);
        boy.show();
        System.out.println (boy);

        //关闭ioc容器
        context.close ( );
    }
}
