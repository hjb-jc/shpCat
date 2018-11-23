package com.ShpCart.web;

import com.ShpCart.dao.JDBCUtil;
import com.ShpCart.entity.Products;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Individual")
public class Individual extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String i_name = req.getParameter("i_name");
        String sql="select * from infoProducts where t_id=(select t_id from typeProducts where t_name=? )";
        List<Products> products = JDBCUtil.preparedQuery(Products.class, sql,i_name);
        req.setAttribute("products",products);
        req.getRequestDispatcher("/jsp/indexs.jsp").forward(req,resp);
        //resp.getWriter().write(new Gson().toJson(products));
       // resp.sendRedirect("/jsp/Individual.jsp");
    }
}
