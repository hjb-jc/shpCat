package com.ShpCart.entity;
/*
 * 商品类型实体类
 * */
public class ClassFication {
   private int t_id;
   private String t_name;

   public ClassFication(){}

    public ClassFication(int t_id, String t_name) {
        this.t_id = t_id;
        this.t_name = t_name;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }
}
