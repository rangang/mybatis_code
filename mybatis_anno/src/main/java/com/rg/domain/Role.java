package com.rg.domain;

/**
 * @BelongsProject: mybatis_anno
 * @Author: RG
 * @CreateTime: 2022/10/25 7:29 下午
 * @Description:
 */
public class Role {
    private Integer id;
    private String rolename;
    private String roleDesc;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
