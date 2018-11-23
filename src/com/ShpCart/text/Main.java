package com.ShpCart.text;

import com.ShpCart.dao.SqlMyJDBC;
import com.ShpCart.entity.Products;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SqlMyJDBC sqlMyJDBC = new SqlMyJDBC();
        //List<Products> select = sqlMyJDBC.select("select * from infoProducts");
        List<Map<String, Object>> query = sqlMyJDBC.query("select * from infoProducts");
        System.out.println(query);
    }
}
