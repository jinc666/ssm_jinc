package com.jinchao.service;

import com.jinchao.domain.Orders;

import java.util.List;

public interface IOrdersService {

    /**
     * 查询所有订单
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<Orders> findAll(int page, int size)throws Exception;

    /**
     * 根据订单id查询订单详情
     * @param ordersId
     * @return
     * @throws Exception
     */
    Orders findById(String ordersId) throws Exception;

}
