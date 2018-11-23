package com.ShpCart.web;

import com.ShpCart.dao.Carts;
import com.ShpCart.dao.JDBCUtil;
import com.ShpCart.dao.ShpDAO;
import com.ShpCart.entity.Products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AddCartShp")
public class AddCartShp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/jsp/cart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] ids =req.getParameterValues("id");

        for(int i=0;i<ids.length;i++) {
            Products p = (Products) new ShpDAO().getProductById(ids[i]);
            Carts carts = (Carts) req.getSession().getAttribute("Carts");
            carts.addShp(p);
            System.out.println(p);
        }
        resp.sendRedirect("/jsp/cart.jsp");
    }
}
