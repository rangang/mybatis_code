package com.rg.test;

import com.rg.domain.Orders;
import com.rg.domain.Role;
import com.rg.domain.User;
import com.rg.mapper.OrderMapper;
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
 * @BelongsProject: mybatis_multitable
 * @Author: RG
 * @CreateTime: 2022/10/24 2:21 下午
 * @Description:
 */
public class MybatisTest {

    /**
     * 一对一关联查询：查询所有订单，与此同时还要查询出每个订单所属的用户信息
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> orders = orderMapper.findAllWithUser();

        for (Orders order : orders) {
            System.out.println(order);
        }

    }

    /**
     * 一对多关联查询：查询所有用户，与此同时还要查询出每个用户所属的订单信息
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.findAllWithOrder();

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();

    }

    /**
     * 多对多关联查询：查询所有用户，与此同时还要查询出每个用户所属的角色信息
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> list = userMapper.findAllWithRole();

        for (User user : list) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    /**
     * 一对一嵌套查询：查询所有订单，与此同时还要查询出每个订单所属的用户信息
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Orders> allWithUser2 = mapper.findAllWithUser2();
        for (Orders orders : allWithUser2) {
            System.out.println(orders);
        }

        sqlSession.close();
    }

    /**
     * 一对多嵌套查询：查询所有用户，与此同时还要查询出每个用户所属的订单信息
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allWithOrder2 = mapper.findAllWithOrder2();

        for (User user : allWithOrder2) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    /**
     * 多对多嵌套查询：查询所有用户，与此同时还要查询出每个用户所属的角色信息
     * @throws IOException
     */
    @Test
    public void test6() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allWithRole2 = mapper.findAllWithRole2();

        for (User user : allWithRole2) {
            System.out.println(user);
        }

        sqlSession.close();
    }

}
