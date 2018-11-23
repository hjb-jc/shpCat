<%@ page import="com.ShpCart.entity.CartItem" %>
<%@ page import="com.ShpCart.dao.Carts" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/ext.css"/>
</head>
<%
    Carts carts=(Carts)session.getAttribute("Carts");
    Map<Integer,CartItem> map= carts.getCartItemInfo();
%>
<body>
<div class="container">
    <div class="row box" style="margin-bottom: 2rem; margin-top: 2rem;">
        <div class="col-md-10 column">
            <h1 style="color: red; margin: auto;">我的购物车</h1>
        </div>
        <div class="col-md-2 column" align="right">
            <a href="/ShpInfoAll">继续购物</a>
        </div>
    </div>

    <div class="row well well-sm">
        <div class="col-md-2 column" align="left">
            <input type="checkbox"/>&nbsp;全选
        </div>
        <div class="col-md-3 column" align="left">商品信息</div>
        <div class="col-md-2 column" align="left">单价</div>
        <div class="col-md-2 column" align="left">数量</div>
        <div class="col-md-2 column" align="left">金额</div>
        <div class="col-md-1 column" align="left">操作</div>
    </div>
    <form action="" method="post">
       <% for(CartItem list:map.values()){ %>
        <%=list.getP().getI_info()%>
        <!-- 购物车列表 -->
        <div class="row well well-sm box">
            <div class="col-md-2 column" align="left">
                <input type="checkbox"/>
                <img alt="120x120" width="120rem" height="120rem"
                     src="<%=list.getP().getI_img()%>"/>
            </div>
            <div class="col-md-3 column" align="left">
                <p>
                    <%=list.getP().getI_info()%>
                </p>
            </div>
            <div class="col-md-2 column" align="left">
                <p style="font-size: large;"><%=list.getP().getI_price()%></p>
            </div>
            <div class="col-md-2 column" align="left">
                <input type="number" name="buyNum" value="<%=list.getCount()%>"/>
            </div>
            <div class="col-md-2 column" align="left">
                <p style="color: #ff2d38; font-size: large;">¥ 4458.00</p>
            </div>
            <div class="col-md-1 column" align="left">
                <input type="button" class="btn btn-danger" name="del" value="删除"/>
            </div>
        </div>
        <%}%>
    </form>
</div>

</body>
<script src="/js/operation.js"></script>
</html>
