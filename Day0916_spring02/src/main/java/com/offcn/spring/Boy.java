package com.offcn.spring;/**
 * Created by Administrator on 2019/9/16 0016.
 */

import java.util.List;

/**
 * @author Administrator
 * @date 2019/9/16 0016 9:46
 * @description
 */
public class Boy {
    public int age;
    //用于接收容器注入的对象
    public BeautifulGirl girl;

    public List<Car> cars;

    public Boy() {
        System.out.println("boy:Boy()");
    }

    public void show(){
        girl.toSayYou();
        for (Car car : cars) {//iter
            System.out.println(car);
        }
        System.out.println("boy:"+age);
    }

    public BeautifulGirl getGirl() {
        return girl;
    }

    public void setGirl(BeautifulGirl girl) {
        this.girl = girl;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void  init(){
        System.out.println("init()");


    }
    public void destroy(){
        System.out.println("destroy()");


    }
}
