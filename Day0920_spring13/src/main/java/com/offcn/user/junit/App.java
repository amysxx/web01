package com.offcn.user.junit;


import com.offcn.user.dao.entity.UserEntity;
import com.offcn.user.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public ClassPathXmlApplicationContext context = null;
    public UserService service = null;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        service = context.getBean(UserService.class);
    }

    /**
     * 查询全部
     */
    @Test
    public void queryAll() throws SQLException {
        List<UserEntity> list = service.queryAll();
        for (UserEntity userEntity : list) {
            System.out.println(userEntity);
        }
    }

    /**
     * 添加
     */
    @Test
    public void insertUser() throws SQLException {
        UserEntity userEntity=new UserEntity();
        userEntity.setUname("谢逊");
        userEntity.setUpass("xx12345");
        userEntity.setUage(40);
        service.insertUser(userEntity);
    }
}
