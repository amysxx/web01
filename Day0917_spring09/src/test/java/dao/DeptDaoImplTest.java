package dao;

import com.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author amy
 * @date 2019/9/24 2:15
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext2.xml")
public class DeptDaoImplTest {

    @Autowired
    public DeptService deptService;
    @Test
    public void insertDept() {
       deptService.insert ();
    }
}