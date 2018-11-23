package com.ShpCart.entity;

import com.ShpCart.entity.Products;
/*
    购物车项类
 */
public class CartItem {
    private Products p;  //商品作为购物项的属性
    private int count;  //购物项的商品数量

    public CartItem(){}

    public CartItem(Products p, int count) {
        this.p = p;
        this.count = count;
    }

    public Products getP() {
        return p;
    }

    public void setP(Products p) {
        this.p = p;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
