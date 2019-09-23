package com.offcn.spring.aspect;/**
 * Created by Administrator on 2019/9/17 0017.
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 切面类
 *
 * @author Administrator
 * @date 2019/9/17 0017 10:07
 * @description
 */
@Component
@Aspect
public class UserAspect {//切面类
    //定义全局切入点
    @Pointcut("execution(* com.offcn.spring.service.UserServiceImpl.insert(..))")
    public  void insertPointCut(){//方法名称就是切入点名称

    }

    //@Before("execution(* com.offcn.spring.service.UserServiceImpl.insert(..))")
    @Before("insertPointCut()")
    public void validate() {//横切关注点
        System.out.println("权限验证......");
    }

    public void validateParam(int proNum,String proName) {//横切关注点
        System.out.println("权限验证......:"+proName+"  "+proNum);
    }

    @AfterReturning("insertPointCut()")
    public void log() {//横切关注点
        System.out.println("记录日志......");
    }

    public  void logDate(List<Date> list){//参数用于接收业务方法的返回值
        System.out.println("记录日志......"+list);
    }

    /**
     * 环绕通知
     */
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("前......");
        Object obj = proceedingJoinPoint.proceed();// method.invoke  filterChain.doFilter()
        System.out.println("后......");
        return obj;
    }

    /**
     * 异常通知
     */
    public void showException() {
        System.out.println("异常通知......");
    }
    /**
     * 最终通知
     */
    public void afterMethod(){
        System.out.println("最终通知......");
    }
}
