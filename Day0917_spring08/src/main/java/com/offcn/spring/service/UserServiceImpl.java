package com.offcn.spring.service;/**
 * Created by Administrator on 2019/9/16 0016.
 */

import com.offcn.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @date 2019/9/16 0016 16:47
 * @description
 */
@Service
public class UserServiceImpl implements UserService{
    //注入dao层对象
    @Autowired
    public UserDao userDao;
    @Override
    public void insert() {
        System.out.println("service:insert()");
        //调用dao层
        userDao.insert();
    }
    public void insertParam(int proNum,String proName) {
        System.out.println("service:insert():"+proName+" "+proNum);
        //调用dao层
        userDao.insert();
    }
    public List<Date> queryDate(){
        System.out.println("service:queryDate()");
        List<Date> list=new ArrayList<Date>();
        list.add(new Date());
        list.add(new Date());
        list.add(new Date());
        return list;
    }
    @Override
    public void delete() {
        System.out.println("service:delete()");
    }

    @Override
    public void query() {
        System.out.println("service:query()");
    }

    @Override
    public void update() {
        System.out.println("service:update()");
    }

    @Override
    public void insertException() {
        System.out.println("service:insertException()");
        //System.out.println(10/0);

    }


    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
