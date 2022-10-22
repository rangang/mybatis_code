package com.rg.mapper;

import com.rg.domain.User;

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



}
