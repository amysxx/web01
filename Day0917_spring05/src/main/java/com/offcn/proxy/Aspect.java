package com.offcn.proxy;/**
 * Created by Administrator on 2019/9/17 0017.
 */

/**
 * 封装了横切关注点方法
 * @author Administrator
 * @date 2019/9/17 0017 10:07
 * @description
 */
public class Aspect {//切面类

    public void validate() {//横切关注点
        System.out.println("权限验证......");
    }

    public void log() {//横切关注点
        System.out.println("记录日志......");
    }
}
