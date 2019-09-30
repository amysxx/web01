package com.offcn; /**
 * Created by Administrator on 2019/9/16 0016.
 */

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

    public void toSayYou(){
        System.out.println(like+"，我考虑、考虑......");
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
