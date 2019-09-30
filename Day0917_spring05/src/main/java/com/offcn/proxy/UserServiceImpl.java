package com.offcn.proxy;

/**
 * 实现类
 */
public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {//核心方法
        System.out.println("jdk add user");
    }

    @Override
    public void updateUser() {
        System.out.println("jdk update user");
    }
}
