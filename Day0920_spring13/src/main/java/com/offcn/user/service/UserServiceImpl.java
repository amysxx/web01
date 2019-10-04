package com.offcn.user.service;/**
 * Created by Administrator on 2019/9/19 0019.
 */

import com.offcn.user.dao.UserDao;
import com.offcn.user.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * 业务层接口
 * @author Administrator
 * @date 2019/9/19 0019 9:50
 * @description
 */
@Service
public class UserServiceImpl implements UserService{
    //注入dao层对象
    @Autowired
    public  UserDao userDao;

    @Override
    public List<UserEntity> queryAll() throws SQLException {
        //调用dao层并返回结果
        return userDao.queryAll();
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public int insertUser(UserEntity user) throws SQLException {
        return userDao.insertUser(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}