package com.rg.test;

import com.rg.domain.User;
import com.rg.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @BelongsProject: mybatis_dao
 * @Author: RG
 * @CreateTime: 2022/10/21 4:16 下午
 * @Description:
 */
public class MybatisTest {

    /**
     * mybatis的Dao层代理方式测试
     * @throws IOException
     */
    @Test
    public void testFindById() throws IOException {

        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的其实是基于UserMapper所产生的代理对象 底层：JDK动态代理 实际类型：proxy
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(1);
        System.out.println(user);


    }

}
