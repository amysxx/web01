package com.offcn.spring.controller;/**
 * Created by Administrator on 2019/9/16 0016.
 */

import com.offcn.spring.service.UserService;

/**
 * 控制器
 * @author Administrator
 * @date 2019/9/16 0016 16:49
 * @description
 */
public class UserController {
    //注入业务层对象
    public UserService userService;
    public void execute(){
        System.out.println (userService.getClass () );
        System.out.println("controller:execute()");
        userService.insert();
        System.out.println (userService.getClass () );
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
