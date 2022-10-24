package com.rg.mapper;

import com.rg.domain.User;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

/**
 * @BelongsProject: mybatis_dao
 * @Author: RG
 * @CreateTime: 2022/10/21 3:44 下午
 * @Description:
 */
public interface UserMapper {

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    public User findById(Integer id);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAllResultMap();

    /**
     * 多条件查询方式一
     * @return
     */
    public List<User> findByIdAndUsername1(Integer id, String username);

    /**
     * 多条件查询方式二
     * @param id
     * @param username
     * @return
     */
    public List<User> findByIdAndUsername2(@Param("id") Integer id, @Param("username") String username);

    /**
     * 多条件查询方式三
     * @param user
     * @return
     */
    public List<User> findByIdAndUsername3(User user);

    /**
     * 模糊查询：方式一
     * @param username
     * @return
     */
    public List<User> findByUsername1(String username);

    /**
     * 模糊查询：方式二
     * @param username
     * @return
     */
    public List<User> findByUsername2(String username);

    /**
     * 添加用户，获取返回主键：方式一
     * @param user
     */
    public void saveUser(User user);

    /**
     * 添加用户，获取返回主键：方式二
     * @param user
     */
    public void saveUser2(User user);

    /**
     * 动态SQL之if:多条件查询
     * @return
     */
    public List<User> findByIdAndUsernameIf(User user);

    /**
     * 动态SQL之set:动态更新
     * @param user
     */
    public void updateIf(User user);

    /**
     * 动态SQL之foreach:多值查询：集合
     * @param ids
     * @return
     */
    public List<User> findByList(List<Integer> ids);

    /**
     * 动态SQL之foreach：多值查询：数组
     * @param ids
     * @return
     */
    public List<User> findByArray(Integer[] ids);

}
