package com.mapper;

import com.pojo.TblUser;
import com.pojo.TblUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblUserMapper {
    long countByExample(TblUserExample example);

    int deleteByExample(TblUserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(TblUser record);

    int insertSelective(TblUser record);

    List<TblUser> selectByExample(TblUserExample example);

    TblUser selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") TblUser record, @Param("example") TblUserExample example);

    int updateByExample(@Param("record") TblUser record, @Param("example") TblUserExample example);

    int updateByPrimaryKeySelective(TblUser record);

    int updateByPrimaryKey(TblUser record);
}