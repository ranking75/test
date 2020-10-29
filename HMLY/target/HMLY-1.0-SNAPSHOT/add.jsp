<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/10/12
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <title>添加联系人</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
</head>
<body>
    <div class="container">
        <form action="/day04/addUserSerlet">
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
            </div>
            <div class="form-group">
                <label>性别</label>
                <input type="radio" class="gender" name="gender" value="男" checked/>男
                <input type="radio" class="gender" name="gender" value="女"/>女
            </div>
            <div class="form-group">
                <label for="age">年龄</label>
                <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
            </div>
            <div class="form-group">
                <label for="address">年龄</label>
                <select name="address" class="form-control" id="address" >
                    <option value="陕西">陕西</option>
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                </select>
            </div>
            <div class="form-group">
                <label for="qq">QQ</label>
                <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入qq">
            </div>
            <div class="form-group">
                <label for="email">邮箱</label>
                <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱">
            </div>
            <div class="form-group">
                <input class="btn btn-primary"  type="submit" value="提交">
            </div>

        </form>

    </div>

</body>
</html>
