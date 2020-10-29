<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/10/13
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <title>用户信息管理系统</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
    <title>Title</title>
    <script>
        window.onload=function () {
            var img = document.getElementById("check");
            img.onclick=function () {
                var time = new Date().getTime();

                img.src="/day04/checkCodeServlet?"+time;
            }
        }
    </script>
</head>
<body>
<div class="container" style="...">
    <h3 style="text-align: center;">管理员登录</h3>
    <form action="/day04/loginServlet" method="post">
            <div class="form-group">
                <label for="user">用户名</label>
                <input type="text" name="username" class="form-control" id="user" placeholder="请输入用户名"/>
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input type="text" name="password" class="form-control" id="password" placeholder="请输入密码"/>
            </div>
            <div class="form-group">
                <label for="check">验证码</label>
                <<input type="text" name="checkcode" class="form-control" id="checkcode" placeholder="请输入验证码"/>
                 <img style="margin-top: 5px" id="check" src="/day04/checkCodeServlet" />
            </div>
            <div class="form-group">
                <input class="btn btn btn-primary" type="submit" value="登录" >
            </div>
    </form>


    <div class="alert alert-warning alert-dismissable" role="alert">
        <button type="button" class="close" >
            <span>x</span>
        </button>
        <strong>${show}</strong>
    </div>
</div>
<div style="float: right;margin: 5px">
    <td  align="center"><a class="btn btn-primary" href="register.jsp">注册</a> </td>
</div>


</body>
</html>