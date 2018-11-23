package com.ShpCart.web;

import com.ShpCart.dao.JDBCUtil;
import com.ShpCart.dao.SqlMyJDBC;
import com.ShpCart.entity.Products;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/ShpInfoAll")
public class ShpInfoAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //SqlMyJDBC sqlMyJDBC = new SqlMyJDBC();
        //String sql="select * from  typeProducts as t , infoProducts as i where t.t_id= i.t_id";
       // List<Products> products = sqlMyJDBC.select(sql);
       // List<Map<String, Object>> query = sqlMyJDBC.query(sql);
        String sql="select * from infoProducts";
        List<Products> products = JDBCUtil.preparedQuery(Products.class,sql);
        req.setAttribute("products",products);
        req.getRequestDispatcher("/jsp/indexs.jsp").forward(req,resp);
    }
}
