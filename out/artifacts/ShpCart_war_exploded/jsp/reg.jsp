<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="regModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document" style="width: 30%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h3 class="modal-title">用户注册</h3>
            </div>
            <form class="form-horizontal" role="form" id="frm">
            <div class="modal-body">
                <div class="row" style="margin: 1rem;">
                    <div class="col-md-12">

                            <div class="form-group">
                                <input type="text" class="form-control" id="account" name="account" placeholder="账号"/>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" id="password" name="password" placeholder="密码"/>
                            </div>
                            <div class="form-group">
                                <input type="tel" class="form-control" id="tel" name="tel" placeholder="手机"/>
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control" id="email" name="email" placeholder="邮箱"/>
                            </div>

                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" name="submit" class="btn btn-primary">注册</button>
            </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<a href="/jsp/login.jsp">返回登录页面</a>

<script src="/js/jquery-3.3.1.min.js"></script>
<script>
    $("#frm").submit(function () {
       $.ajax({
           type:"GET",
           url:"/regUser",
           data:$("#frm").serialize(),
           datatype:"json",
           contentType : "application/x-www-form-urlencoded; charset=utf-8",
           success:function (data) {
               alert("ok!");
           }
       });
    });
</script>
