package com.offcn.mybatis.entity;

/**
 * 用户实体类
 * 
 * @author Administrator
 *
 */
public class UserEntity {
	/** 对象标识符(与表中主见对应属性) */
	public Integer uid;  //int    null
	/** 用户名 */
	public String uname;
	/** 密码 */
	public String upass;
	/** 年龄 */
	public Integer uage;

	public UserEntity() {

	}

    public UserEntity(Integer uid, String uname, String upass, Integer uage) {
        this.uid = uid;
        this.uname = uname;
        this.upass = upass;
        this.uage = uage;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }
}
