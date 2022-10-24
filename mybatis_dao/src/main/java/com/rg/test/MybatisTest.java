package com.rg.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rg.domain.User;
import com.rg.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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

        // 释放资源
        sqlSession.close();

    }

    @Test
    public void testFindAllResultMap() throws IOException {

        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 基于UserMapper所产生的代理对象，底层：JDK动态代理 实际类型：proxy
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAllResultMap();
        // 打印
        for (User user : userList) {
            System.out.println(user);
        }

        // 释放资源
        sqlSession.close();

    }

    @Test
    public void testFindByIdAndUsername1() throws IOException {

        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 基于UserMapper所产生的代理对象，底层：JDK动态代理 实际类型：proxy
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findByIdAndUsername1(5, "rg");
        for (User user : users) {
            System.out.println(user);
        }

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testFindByIdAndUsername2() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 基于UserMapper所产生的代理对象，底层：JDK动态代理，实际类型：proxy
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findByIdAndUsername2(5, "rg");
        for (User user : users) {
            System.out.println(user);
        }
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testFindByIdAndUsername3() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 基于UserMapper所产生代理对象，底层：JDK动态代理，实际类型：proxy
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(5);
        user.setUsername("rg");
        List<User> users = userMapper.findByIdAndUsername3(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testFindByUsername() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 基于UserMapper所产生的代理对象，底层：JDK动态代理，实际类型：proxy
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findByUsername1("%r%");
        for (User user : users) {
            System.out.println(user);
        }
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testFindByUsername2() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 基于UserMapper所产生的代理对象，底层：JDK动态代理，实际类型：proxy
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findByUsername2("%r%");
        for (User user : users) {
            System.out.println(user);
        }
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testSaveUser() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 基于UserMapper所产生的代理对象，底层：JDK动态代理，实际类型：proxy
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("testName");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("cd");
        userMapper.saveUser(user);
        System.out.println(user);

        // 手动提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testSaveUser2() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 基于UserMapper所产生的代理对象，底层：JDK动态代理，实际类型：proxy
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("测试1");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("sz");

        userMapper.saveUser2(user);
        System.out.println(user);

        // 手动提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testFindByIdAndUsername() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 基于UserMapper产生代理对象，底层：JDK动态代理，实际类型：proxy
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        // user.setId(5);
        // user.setUsername("rg");
        List<User> users = userMapper.findByIdAndUsernameIf(user);
        for (User user1 : users) {
            System.out.println(user1);
        }

        // 释放资源
        sqlSession.close();

    }

    @Test
    public void testUpdateIf() throws IOException {

        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 基于UserMapper所产生的代理对象，底层：JDK动态代理，实际类型：proxy
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(8);
        user.setUsername("RRG");
        userMapper.updateIf(user);

        // 手动提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();

    }

    @Test
    public void testFindByList() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        ids.add(5);
        List<User> users = userMapper.findByList(ids);
        for (User user : users) {
            System.out.println(user);
        }

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testFindByArray() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Integer[] ids = {2,6,8};
        List<User> users = userMapper.findByArray(ids);
        for (User user : users) {
            System.out.println(user);
        }

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testPageHelper() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 设置分页参数
        PageHelper.startPage(1,2);

        List<User> users = userMapper.findAllResultMap();
        for (User user : users) {
            System.out.println(user);
        }

        PageInfo<User> pageInfo = new PageInfo<>(users);
        System.out.println(pageInfo);

        // 释放资源
        sqlSession.close();
    }

}
