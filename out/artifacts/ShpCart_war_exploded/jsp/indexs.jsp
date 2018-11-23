<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/ext.css"/>
</head>
<body>
<div class="container">
    <div class="row box" style="margin-top: 2rem; margin-bottom: 2rem;">
        <div class="col-md-3 column">
            <!-- 修改bootstrap中h1的margin-->
            <h1 style="color: red; margin: auto;">挖宝网</h1>
        </div>
        <div class="col-md-6 column">
            <form role="form" class="form-inline" action="/ShpSearch" method="get">
                <div class="form-group">
                    <input type="text" size="60" class="form-control" name="search" placeholder="搜一下"/>
                    <input type="submit" class="btn btn-primary" value="搜索"/>
                </div>
            </form>
        </div>
        <div class="col-md-2 column" align="right">
            <a id="carthref" href="#"><span class="badge pull-right">2</span>我的购物车</a>
        </div>
        <div class="col-md-1 column" align="right">
            <a href="/jsp/login.jsp" id="loginhref">登陆</a>/<a href="/jsp/reg.jsp" id="reghref">注册</a>
        </div>

    </div>
    <div class="row">
        <!-- 商品列表 -->
        <div class="col-md-2 column">
            <ul class="nav navcolor nav-pills nav-stacked">
                <li class="active">
                    <a href="#">分类</a>
                </li>
            </ul>
        </div>

        <form>
            <div class="col-md-10 column">
                <div class="row">
                    <c:forEach items="${products}" var="product">
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <img alt="300x300"
                                     src="${product.i_img}"/>

                                <div class="caption">
                                    <h3 style="color: red; font-weight: bold;"><f:formatNumber
                                            value="${product.i_price}"
                                            type="CURRENCY"
                                            currencySymbol="￥"/></h3>
                                    <p>
                                            ${product.i_info}
                                    </p>
                                    <p>${product.i_name}</p>
                                    <p>
                                        <a class="btn btn-primary addcart" href="/AddCartShp?id=${product.i_id}">加入购物车</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </form>
        <!-- 模态框 -->
        <div id="modal"></div>
    </div>
</div>
</div>

</body>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/operation.js"></script>

<script>
    $(function () {
        $.get("/Classification", function (data) {
            for(var i in data) {
                $("ul").append("<li><a href='/Individual?i_name="+ data[i].t_name+"'>" + data[i].t_name + "</a></li>");
            }
        }, "json");
    });

</script>

<script>
    $(function () {
        $("#loginhref").on("click", function () {
            $("#modal").load("/jsp/login.jsp", function () {
                $("#loginModal").modal("show");
                alert("ok");
            });
        });
        $("#reghref").on("click", function () {
            $("#modal").load("reg.jsp", function () {
                $('#regModal').modal('show');
            });
        });
    });
</script>
</html>
