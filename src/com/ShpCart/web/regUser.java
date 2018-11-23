package com.ShpCart.web;

import com.ShpCart.dao.JDBCUtil;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/regUser")
public class regUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");
        String sql= "insert into regInfo(r_number,r_nubHpone,r_pwd,r_main) values(?,?,?,?)";
        int i = JDBCUtil.preparedUpdate(sql,account,tel,password,email);

        System.out.println(i);
        resp.getWriter().write(new Gson().toJson(account));
        //req.getRequestDispatcher("").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
