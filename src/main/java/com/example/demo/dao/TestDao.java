package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @program: demo
 * @description:
 * @author: Mr.HuangDaDa
 * @create: 2022-07-27 17:53
 **/
@Mapper
public interface TestDao {
    @Select("select stock from goods_stock where goods_no=#{goods_no,jdbcType=INTEGER} and isActive=1 ")
    Integer getDataSource(@Param("goods_no") Integer goods_no );


    @Update("update goods_stock set stock=#{quantity,jdbcType=INTEGER} where goods_no=#{goods_no,jdbcType=INTEGER}")
    void update(@Param("quantity")Integer quantity,@Param("goods_no")Integer goods_no);
}
