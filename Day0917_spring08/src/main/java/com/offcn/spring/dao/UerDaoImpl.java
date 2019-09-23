package com.offcn.spring.dao;/**
 * Created by Administrator on 2019/9/16 0016.
 */

import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @date 2019/9/16 0016 16:45
 * @description
 */
@Repository
public class UerDaoImpl implements UserDao {

    public void insert() {
        System.out.println("dao:insert()");
    }
}
