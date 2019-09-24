package com.daomain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author amy
 * @date 2019/9/24 1:55
 */
@Data
public class DeptEntity implements Serializable {
    public Integer deptno;
    public String dname;
    public String loc;
    public Integer dstatus;

}