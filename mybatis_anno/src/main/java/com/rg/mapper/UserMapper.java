package com.rg.mapper;

import com.rg.domain.Role;
import com.rg.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @BelongsProject: mybatis_anno
 * @Author: RG
 * @CreateTime: 2022/10/25 7:30 下午
 * @Description:
 */
public interface UserMapper {

    /**
     * 查询用户
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    public void save(User user);

    /**
     * 修改用户
     * @param user
     */
    @Update("update user set username = #{username},birthday = #{birthday} where id = #{id}")
    public void update(User user);

    /**
     * 删除用户
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    public void delete(Integer id);

    /**
     * 根据ID查询用户信息
     * @param uid
     * @return
     */
    @Select("select * from user where id = #{uid}")
    public User findById(Integer uid);

    /**
     * 查询所有用户，及关联的订单
     * @return
     */
    @Select("select * from user")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "address",column = "address"),
            @Result(property = "orderList",javaType = List.class,column = "id",many = @Many(select = "com.rg.mapper.OrderMapper.findByUid"))
    })
    public List<User> findAllWithOrder();

    /**
     * 查询所有用户，及关联的角色
     * @return
     */
    @Select("select * from user")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "address",column = "address"),
            @Result(property = "roleList",javaType = List.class,column = "id",many = @Many(select = "com.rg.mapper.RoleMapper.findAllById"))
    })
    public List<User> findAllWithRole();

}
