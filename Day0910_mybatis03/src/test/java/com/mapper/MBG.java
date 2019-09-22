package com.mapper;

import com.pojo.TblUser;
import com.pojo.TblUserExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author amy
 * @date 2019/9/15 16:31
 */
public class MBG {
    public SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init() {
        // 加载配置文件
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("mybatisConfig.xml");
            // 创建构造器对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            // 创建工厂
            sqlSessionFactory = builder.build(reader);
            // 创建执行对象
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testSimple(){
        SqlSession sqlSession = sqlSessionFactory.openSession (true);
        TblUserMapper mapper = sqlSession.getMapper (TblUserMapper.class);
        TblUser tblUser = mapper.selectByPrimaryKey (1);

        TblUserExample tblUserExample = new TblUserExample ( );
        TblUserExample.Criteria criteria = tblUserExample.createCriteria ( );
        criteria.andUnameLike ("%贤%");
        List<String> list = new ArrayList<String> (){{
            add ("789");
            add ("456");
            add ("123");
        }};
        criteria.andUpassIn (list);

        List<TblUser> list1 = mapper.selectByExample (tblUserExample);
        for(TblUser user : list1){
            System.out.println (user );
        }
        System.out.println (tblUser );
    }
}
