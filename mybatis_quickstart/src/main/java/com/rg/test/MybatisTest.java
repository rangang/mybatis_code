package com.rg.test;

import com.rg.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: mybatis_quickstart
 * @Author: RG
 * @CreateTime: 2022/10/20 7:39 下午
 * @Description:
 */
public class MybatisTest {

    /**
     * 快速入门测试方法
     */

    @Test
    public void mybatisQuickStart() throws IOException {

        // 1. 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 2. 获取sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 3. 获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4. 执行sql
        List<User> list = sqlSession.selectList("userMapper.findAll");

        // 5. 遍历打印结果
        for (User user : list) {
            System.out.println(user);
        }

        // 6. 关闭资源
        sqlSession.close();

    }

    /**
     * 测试新增用户
     * @throws IOException
     */
    @Test
    public void testSave() throws IOException {

        // 1.加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 3.获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("rg");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("成都");
        // 4.执行sql
        sqlSession.insert("userMapper.save",user);

        // 手动提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();

    }

    /**
     * 测试更新用户
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {

        // 1.加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 3.获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4.执行sql
        User user = new User();
        user.setId(3);
        user.setUsername("rg1");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("成都1");
        sqlSession.update("userMapper.update",user);

        // 手动提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();

    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDelete() throws IOException {

        // 1.加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 3.获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4.执行sql
        sqlSession.delete("userMapper.delete",4);

        // 手动提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();

    }

}
