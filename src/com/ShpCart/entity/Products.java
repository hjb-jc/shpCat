package com.ShpCart.entity;
/*
 * 商品信息实体类
 * */
import java.math.BigDecimal;

public class Products {
    private int i_id;
    private int t_id;
    private String i_name;
    private BigDecimal i_price;
    private String i_info;
    private String i_img;

    public Products(){}

    public Products(int i_id, int t_id, String i_name, BigDecimal i_price, String i_info, String i_img) {
        this.i_id = i_id;
        this.t_id = t_id;
        this.i_name = i_name;
        this.i_price = i_price;
        this.i_info = i_info;
        this.i_img = i_img;
    }

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getI_name() {
        return i_name;
    }

    public void setI_name(String i_name) {
        this.i_name = i_name;
    }

    public BigDecimal getI_price() {
        return i_price;
    }

    public void setI_price(BigDecimal i_price) {
        this.i_price = i_price;
    }

    public String getI_info() {
        return i_info;
    }

    public void setI_info(String i_info) {
        this.i_info = i_info;
    }

    public String getI_img() {
        return i_img;
    }

    public void setI_img(String i_img) {
        this.i_img = i_img;
    }
}
