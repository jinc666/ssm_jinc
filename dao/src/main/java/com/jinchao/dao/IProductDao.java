package com.jinchao.dao;

import com.jinchao.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IProductDao {
    //根据id查询产品值的id
    @Select("select * from product where id = #{id}")
    Product findById(String id) throws Exception;


    @Select("select * from product")
    List<Product> findAll()throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product)throws Exception;

    @Delete("delete from product where id = #{id}")
    void deleteProduct(String id);

    @Select("select id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus from product where id = #{id}")
    Product findProductById(String id);

    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id = #{id}")
    void updateProduct(Product product);


    public static void main(String[] args) {
        System.out.println("HelloWorld");
    }
}
