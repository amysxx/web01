package com.offcn.spring.controller;/**
 * Created by Administrator on 2019/9/16 0016.
 */

import com.offcn.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 控制器
 *
 * @author Administrator
 * @date 2019/9/16 0016 16:49
 * @description
 */
@Controller
public class UserController {
    //注入业务层对象
    @Autowired
    public UserService userService;

    public void execute() {
        System.out.println("controller:execute()");
        userService.insert();
        //userService.update();
        //userService.query();
        //userService.insertException();
        //userService.insertParam(100,"mate30");
        //userService.queryDate();
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}