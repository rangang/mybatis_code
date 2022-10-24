package com.rg.mapper;

import com.rg.domain.Orders;

import java.util.List;

/**
 * @BelongsProject: mybatis_multitable
 * @Author: RG
 * @CreateTime: 2022/10/24 2:07 下午
 * @Description:
 */
public interface OrderMapper {

    /**
     * 一对一关联查询：查询所有订单，与此同时还要查询出每个订单所属的用户信息
     * @return
     */
    public List<Orders> findAllWithUser();

    /**
     * 一对一嵌套查询：查询所有订单，与此同时还要查询出每个订单所属的用户信息
     * @return
     */
    public List<Orders> findAllWithUser2();

    /**
     * 根据uid查询订单
     * @param uid
     * @return
     */
    public List<Orders> findByUid(Integer uid);

}
