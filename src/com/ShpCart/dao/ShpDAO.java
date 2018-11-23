package com.ShpCart.dao;

import com.ShpCart.entity.Products;

import java.util.List;

/*
    购物车表功能类(添加、删除方法)
 */
public class ShpDAO {
    //获取所有商品信息的方法
    public List<Products> getAllShpInfo(){
        String sql="select * from infoProducts";
        List<Products> products = JDBCUtil.preparedQuery(Products.class,sql);
        return products;
    }

    //根据产品编号查询产品
    public List<Products> getProductById(String id){
        //构建sql语句
        String sql="select * from infoProducts where i_id=?";
        List<Products> p = JDBCUtil.preparedQuery(Products.class, sql,id);
        if(p.size()>0){
             p.get(0);
        }
            return null;
    }
}
