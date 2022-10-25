package com.rg.test;

import com.rg.domain.Order;
import com.rg.domain.User;
import com.rg.mapper.OrderMapper;
import com.rg.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: mybatis_anno
 * @Author: RG
 * @CreateTime: 2022/10/25 7:40 下午
 * @Description:
 */
public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void after() {
        // 手动提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testFindAll() {

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> all = mapper.findAll();

        for (User user : all) {
            System.out.println(user);
        }

    }

    @Test
    public void testSave() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("RGTest");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("cd");
        mapper.save(user);
    }

    @Test
    public void testUpdate() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("TT");
        user.setBirthday(new Date());
        user.setId(9);

        mapper.update(user);
    }

    @Test
    public void testDelete() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.delete(9);
    }

    @Test
    public void testOneToOne() {

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> allWithUser = mapper.findAllWithUser();

        for (Order order : allWithUser) {
            System.out.println(order);
        }

    }

}
