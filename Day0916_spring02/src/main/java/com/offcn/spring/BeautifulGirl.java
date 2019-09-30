package com.offcn.spring; /**
 * Created by Administrator on 2019/9/16 0016.
 */

import java.util.Date;

/**
 * @author Administrator
 * @date 2019/9/16 0016 9:45
 * @description
 */
public class BeautifulGirl {
    /**
     *爱好
     */
    public String like;
    public Date date;
    public  int age;

    public BeautifulGirl(String like, Date date, int age) {
        this.like = like;
        this.date = date;
        this.age = age;
        System.out.println("girl:BeautifulGirl(String like, Date date, int age)");
    }

    public void toSayYou(){
        System.out.println("爱好:"+like+"，我考虑、考虑......"+"\n日期:"+date+"\n年龄:"+age);
    }

}
