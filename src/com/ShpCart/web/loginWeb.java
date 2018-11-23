package com.ShpCart.web;

import com.ShpCart.dao.JDBCUtil;
import com.ShpCart.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/loginWeb")
public class loginWeb extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/jsp/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // String sql="select * from User";
        String account = req.getParameter("account");
        String pwd = req.getParameter("pwd");
        String sql="select * from User where u_name=? and u_pwd=?";
        List<User> users = JDBCUtil.preparedQuery(User.class, sql,account,pwd);

        if(users.size()>0){
            resp.sendRedirect("/jsp/cart.jsp");
        }else{
            resp.sendRedirect("/jsp/ceg.jsp");
        }

    }
}
