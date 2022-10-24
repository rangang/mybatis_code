package com.rg.mapper;

import com.rg.domain.Role;
import com.rg.domain.User;

import java.util.List;

/**
 * @BelongsProject: mybatis_multitable
 * @Author: RG
 * @CreateTime: 2022/10/24 2:47 下午
 * @Description:
 */
public interface UserMapper {

    /**
     * 一对多关联查询：查询所有用户，与此同时还要查询出每个用户所属的订单信息
     * @return
     */
    public List<User> findAllWithOrder();

    /**
     * 多对多关联查询：查询所有用户，与此同时还要查询出每个用户所属的角色信息
     * @return
     */
    public List<User> findAllWithRole();

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    public User findById(Integer id);

    /**
     * 一对多嵌套查询：查询所有用户，与此同时还要查询出每个用户所属的订单信息
     * @return
     */
    public List<User> findAllWithOrder2();

    /**
     * 多对多嵌套查询：查询所有用户，与此同时还要查询出每个用户所属的角色信息
     * @return
     */
    public List<User> findAllWithRole2();
}
