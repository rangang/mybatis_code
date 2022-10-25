package com.rg.mapper;

import com.rg.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Select("select * from user where id = #{uid}")
    public User findById(Integer uid);

}
