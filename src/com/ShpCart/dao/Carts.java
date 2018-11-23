package com.ShpCart.dao;

import com.ShpCart.entity.CartItem;
import com.ShpCart.entity.Products;

import java.util.HashMap;
import java.util.Map;
/*
购物车类
 */
public class Carts {
    Map<Integer, CartItem> map=new HashMap<Integer, CartItem>();

    //添加商品的方法
    public void addShp(Products product){
        //获取map产品里面的id
        CartItem p = map.get(product.getI_id());
        //如果购物车里面是否有此产品
        if(p==null){
            map.put(product.getI_id(),new CartItem(product,1));
        }else{
            p.setCount(product.getI_id()+1);
        }
    }

    //删除商品的方法
    private void del(String id){
        map.remove(Integer.parseInt(id));
    }

    //返回map集合中所有商品信息
    public Map<Integer, CartItem> getCartItemInfo(){
        return map;
    }
}
