package com.dao;


import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author amy
 * @date 2019/9/24 1:56
 */
//@Repository("deptDap")
public class DeptDaoImpl implements DeptDao {
    //@Autowired
    @Setter
    public JdbcTemplate jdbcTemplate;

    @Override
    public void insertDept() {
        /*DataSourceTransactionManager txManager = new DataSourceTransactionManager ( );
        //给事务管理器添加数据源
        txManager.setDataSource (jdbcTemplate.getDataSource ( ));
        //定义事务
        DefaultTransactionDefinition transaction = new DefaultTransactionDefinition ( );
        //设置事务隔离级别
        transaction.setIsolationLevel (TransactionDefinition.ISOLATION_READ_COMMITTED);
        //设置事务传播级别
        transaction.setPropagationBehavior (TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction (transaction);
        //设置事务传播和隔离级别
        String sql = "INSERT INTO `dept`(`DEPTNO`,`DNAME`,`LOC`,`dstatus`) VALUES(?,?,?,?)";
        jdbcTemplate.update (sql, 125, "三傻业务部", "火车站", 1);
        //事务提交
        txManager.commit (status);*/


        //设置事务传播和隔离级别
        String sql = "INSERT INTO `dept`(`DEPTNO`,`DNAME`,`LOC`,`dstatus`) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, 126, "三傻业务部", "火车站",1);
    }

}