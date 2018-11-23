package com.ShpCart.web;

import com.ShpCart.dao.JDBCUtil;
import com.ShpCart.entity.ClassFication;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Classification")
public class Classification extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String sql="select * from infoProducts where t_id=(select t_id from typeProducts where t_name='电脑' )";
        String sql="select * from typeProducts;";
        List<ClassFication> classFications = JDBCUtil.preparedQuery(ClassFication.class, sql);
        //req.setAttribute("classFications",classFications);
        resp.getWriter().write(new Gson().toJson(classFications));
        //req.getRequestDispatcher("/jsp/indexs.jsp").forward(req,resp);
    }
}
