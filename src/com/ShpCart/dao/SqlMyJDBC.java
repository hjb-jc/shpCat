package com.ShpCart.dao;

import com.ShpCart.entity.Products;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlMyJDBC {

    static final String driver = "com.mysql.jdbc.Driver";
    //static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String url ="jdbc:mysql://localhost:3306/ShpCartDB?serverTimezone=GMT&useSSL=false";
    static final String userName = "root";
    static final String pwd = "123456";

    //加载驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //定义连接数据库方法
     public Connection getConnection() {
         Connection con = null;
         try {
             con = DriverManager.getConnection(url, userName, pwd);
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return con;
     }

    Connection con=null;
    PreparedStatement prst=null;
    ResultSet re=null;
    public List<Products> select(String sql) {
        con= getConnection();
        ArrayList<Products> products = new ArrayList<>();
        try {
            con = DriverManager.getConnection(url,userName,pwd );
            prst = con.prepareStatement(sql);
            re = prst.executeQuery();
            while (re.next()) {
                int i_id=re.getInt("i_id");
                int t_id = re.getInt("t_id");
                String i_name = re.getString("i_name");
                BigDecimal i_price = re.getBigDecimal("i_price");
                String i_info = re.getString("i_info");
                String i_img = re.getString("i_img");
                Products products1 = new Products(i_id, t_id, i_name, i_price, i_info, i_img);
                products.add(products1);
            }
                return products;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
                try {
                    if(re!=null) re.close();
                    if(prst!=null) prst.close();
                    if (con!=null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }

    public  void execute(String sql, Object... param) {
        Connection con = getConnection();
        PreparedStatement prst=null;
        try {
            prst = con.prepareStatement(sql);
            //如果有参数，则循环给参数赋值
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    //第一个参数的数值，表示第几个问号，第二个是值
                    prst.setObject(i+1,param[i]);
                }
            }
            int count = prst.executeUpdate();
            if(count>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            System.out.println("创建prepareStatement对象出现异常");
            System.out.println("错误信息"+e.getMessage());
        }finally {
                try {
                    if(prst!=null) prst.close();
                    if(con!=null)  con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    //查询方法
    public List<Map<String,Object>> query(String sql,Object...param){
        List<Map<String,Object>> list= new ArrayList<Map<String,Object>>();
        con=getConnection();
        ResultSet re=null;
        try {
             prst= con.prepareStatement(sql);
            if(param!=null){
                for (int i = 0; i < param.length; i++) {
                    prst.setObject(i+1,param[i]);
                }
            }
            re = prst.executeQuery();
            ResultSetMetaData data = re.getMetaData();
            int count = data.getColumnCount();
            while (re.next()){
                HashMap<String,Object> map= new HashMap<String,Object>();
                for (int i = 1; i <=count ; i++) {
                    String key = data.getCatalogName(i).toLowerCase();
                    Object value = re.getObject(key);
                    map.put(key,value);
                }
                list.add(map);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            try {
                if(re!=null) re.close();
                if(prst!=null) prst.close();
                if(con!=null)con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

