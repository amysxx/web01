package com.offcn.user.service;

import com.offcn.user.dao.entity.UserEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * 业务层接口
 * Created by Administrator on 2019/9/19 0019.
 */
public interface UserService {
    /**
     * 查询全部用户
     *
     * @return
     * @throws SQLException
     */
    public List<UserEntity> queryAll() throws SQLException;

    /**
     * 添加用户
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public int insertUser(UserEntity user) throws SQLException;
}
