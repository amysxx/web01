package com.offcn.spring.dao;/**
 * Created by Administrator on 2019/9/16 0016.
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author Administrator
 * @date 2019/9/16 0016 16:45
 * @description
 */
@Repository("uerDaoImpl")
public class UerDaoImpl implements UserDao {
    //注入数据源
    @Resource(name="dataSource")
    public DruidDataSource dataSource;

    public void insert() {
        System.out.println("dao:insert()");
        try {
            DruidPooledConnection connection = this.getDataSource().getConnection();
            System.out.println(connection.isClosed());//true:断开 false:链接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DruidDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DruidDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
