package com.offcn;/**
 * Created by Administrator on 2019/9/16 0016.
 */

/**
 * @author Administrator
 * @date 2019/9/16 0016 9:46
 * @description
 */
public class Boy {
   public  BeautifulGirl girl;
    public static void main(String[] args) {

        BeautifulGirl girl =new  BeautifulGirl();
        girl.setLike("接送放学、打伞、拎包、记笔记、送早餐、逛街、零食、美食......");

        Boy boy=new Boy();
        boy.setGirl(girl);

        boy.getGirl().toSayYou();
    }

    public BeautifulGirl getGirl() {
        return girl;
    }

    public void setGirl(BeautifulGirl girl) {
        this.girl = girl;
    }
}
