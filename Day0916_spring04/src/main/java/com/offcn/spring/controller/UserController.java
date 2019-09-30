package com.offcn.spring.controller;/**
 * Created by Administrator on 2019/9/16 0016.
 */

import com.offcn.spring.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 控制器
 * @author Administrator
 * @date 2019/9/16 0016 16:49
 * @description
 */
@Component("userController")
public class UserController {
    //注入业务层对象
    @Resource(name="userServiceImpl")
    public UserService userService;
    public void execute(){
        System.out.println("controller:execute()");
        userService.insert();
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
