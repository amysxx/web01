package com.service;

import com.dao.DeptDao;
import lombok.Setter;

/**
 * @author amy
 * @date 2019/9/24 2:28
 */
//@Service("deptService")
public class DeptServiceImpl implements DeptService {

    //@Autowired
    @Setter
    public DeptDao deptDao;

    @Override
    public void insert() {
        deptDao.insertDept ();
    }
}
