package com.offcn.spring.service;/**
 * Created by Administrator on 2019/9/16 0016.
 */

import com.offcn.spring.dao.UserDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2019/9/16 0016 16:47
 * @description
 */
@Component("userServiceImpl")
public class UserServiceImpl implements UserService{
    //注入dao层对象
    @Resource(name="uerDaoImpl")//name="" <bean id=""/>
    public UserDao userDao;
    @Override
    public void insert() {
        System.out.println("service:insert()");
        //调用dao层
        userDao.insert();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
