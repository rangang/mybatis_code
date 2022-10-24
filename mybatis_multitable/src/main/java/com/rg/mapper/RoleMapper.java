package com.rg.mapper;

import com.rg.domain.Role;

import java.util.List;

/**
 * @BelongsProject: mybatis_multitable
 * @Author: RG
 * @CreateTime: 2022/10/24 5:22 下午
 * @Description:
 */
public interface RoleMapper {

    /**
     * 根据用户ID查询角色
     * @param uid
     * @return
     */
    public List<Role> findByUid(Integer uid);


}
