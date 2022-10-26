package com.rg.mapper;

import com.rg.domain.Order;
import com.rg.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: mybatis_anno
 * @Author: RG
 * @CreateTime: 2022/10/25 8:04 下午
 * @Description:
 */
public interface OrderMapper {

    /**
     * 查询所有订单，同时查询订单所属的用户信息
     * @return
     */
    @Select("select * from orders")
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "ordertime",column = "ordertime"),
            @Result(property = "total",column = "total"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "user",javaType = User.class,column = "uid",one = @One(select = "com.rg.mapper.UserMapper.findById"))
    })
    public List<Order> findAllWithUser();

    /**
     * 根据用户ID查询订单
     * @param uid
     * @return
     */
    @Select("select * from orders where uid = #{uid}")
    public List<Order> findByUid(Integer uid);

}
