package com.jinchao.service.impl;

import com.github.pagehelper.PageHelper;
import com.jinchao.dao.IOrdersDao;
import com.jinchao.domain.Orders;
import com.jinchao.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        //参数pageNum是页码值，参数pageSize代表是每页显示条数
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }

    @Override
    public void update(Orders orders)throws Exception {
        ordersDao.update(orders);
    }

    @Override
    public Order save(Orders orders) throws Exception{
        return ordersDao.save(orders);
    }

}
