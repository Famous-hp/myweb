<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html>
<head>
    <title>注册</title>
    <script src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function(){
            $("[type='button']").click(function(){
                var tel=$("[name='tel']").val().trim();
                $.ajax({
                    type:"post",
                    url:"regist",
                    data:{'tel':tel},
                    dataType:"json",
                    /*success:function(data){
                        if(0== data.code){
                            console.log(data.msg);
                        } else if (1 == data.code) {
                            alert(data.msg);
                        } else {
                            alert("系统出现未知异常");
                        }
                    }*/
                   /* error:function(){
                        alert("验证码发送失败！");
                    }*/
                });
            })
        })
    </script>
</head>
<h1>账号注册</h1>
<form action="/zhuce" method="post">
    <p>手机号：<input type="text" name="tel"/>&nbsp;  <input type="button"  value="获取验证码" /></p>
    <p>验证码：<input type="text" name="code"/></p>
    <p><input type="submit" name="注册" /></p>
</form>
</body>
</html>
