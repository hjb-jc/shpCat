package com.ShpCart.web;

import com.ShpCart.dao.JDBCUtil;
import com.ShpCart.entity.Products;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShpSearch")
public class ShpSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
       // String sql="select * from infoProducts where i_name like '%"+search+"%'";
        List<Products> products = JDBCUtil.preparedQuery(Products.class,"select * from infoProducts where i_name like '%"+search+"%' or i_id like '%"+search+"%'");
        req.setAttribute("products",products);
        req.getRequestDispatcher("/jsp/indexs.jsp").forward(req,resp);
    }
}
