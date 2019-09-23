package com.offcn.spring.service;

import java.util.Date;
import java.util.List;

/**
 * 业务层接口
 * Created by Administrator on 2019/9/16 0016.
 */
public interface UserService {
    public void insert();
    public void delete();
    public void query();
    public void update();
    public void insertException();
    public void insertParam(int proNum, String proName);
    public List<Date> queryDate();
}
