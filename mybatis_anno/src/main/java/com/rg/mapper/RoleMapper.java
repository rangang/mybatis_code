package com.rg.mapper;

import com.rg.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: mybatis_anno
 * @Author: RG
 * @CreateTime: 2022/10/26 7:32 下午
 * @Description:
 */
public interface RoleMapper {

    /**
     * 根据用户ID，查询角色信息
     * @param uid
     * @return
     */
    @Select("SELECT * FROM sys_role r INNER JOIN sys_user_role ur ON r.id = ur.roleid WHERE ur.userid = #{uid}")
    public List<Role> findAllById(Integer uid);

}
