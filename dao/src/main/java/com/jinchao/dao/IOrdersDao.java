package com.jinchao.dao;

import com.jinchao.domain.Member;
import com.jinchao.domain.Orders;
import com.jinchao.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface IOrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.jinchao.dao.IProductDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.jinchao.dao.ITravellerDao.findByOrdersId"))
})
    List<Orders> findAll()throws Exception;

    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "productId", column = "productId"),
            @Result(property = "memberId", column = "memberId"),
            @Result(property = "product", column = "productId",javaType = Product.class, one = @One(select = "com.jinchao.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId",javaType = Member.class,one = @One(select = "com.jinchao.dao.IMemberDao.findById")),
            @Result(property = "travellers", column = "id",javaType = List.class,many = @Many(select = "com.jinchao.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId) throws Exception;

    @Update("update orders set orderNum=#{orderNum},peopleCount=#{peopleCount},orderDesc=#{orderDesc},payType=#{payType},orderStatus=#{orderStatus},productId=#{productId},memberId=#{memberId} where id = #{id} ")
    void update(Orders orders)throws Exception;

    @Insert("insert into orders (orderNum,orderTime,peopleCount,orderDesc,payType,orderStatus,productId,memberId) values (#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{productId},#{memberId}) ")
    Order save(Orders orders)throws Exception;
}
