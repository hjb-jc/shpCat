<%--
  Created by IntelliJ IDEA.
  User: 小霸王
  Date: 2018/8/29
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="newAddrModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document" style="width: 40%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h3 class="modal-title">新建地址</h3>
            </div>
            <div class="modal-body">
                <div class="row" style="margin: 1rem;">
                    <div class="col-md-12">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <input type="text" class="form-control" id="receiveUser" name="receiveUser" placeholder="收货人"/>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" id="receiveTell" name="receiveTell" placeholder="联系电话"/>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" id="receiveAddr" name="receiveAddr" placeholder="收获地址"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>
