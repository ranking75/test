<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/10/21
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <div id="header"></div>
        <div class="rg_layout_clearfix">
            <div class="rg_form_left">
                <p>新用户注册</p>
                <p>USER REGISTER</p>
            </div>
            <form id="registerForm" action="/day04/registerUserServlet" method="post">
                <input type="hidden" name="action" value="register">
                <table style="...">
                    <tr>
                        <td class="td_left">
                            <label for="username">用户名</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="username" name="username" placeholder="请输入账号">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="password">密码</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="password" name="password" placeholder="请输入密码">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="email">邮箱</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="email" name="email" placeholder="请输入邮箱">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                        </td>
                        <td class="td_right check">
                            <input type="submit" class="submit" value="注册">
                            <span id="msg" style="..."></span>
                        </td>
                    </tr>
                </table>
            </form>
            </div>
            <div class="rg_form_right">
                <p>
                    已有账号？
                    <a href="#">立即登录</a>
                </p>
            </div>
        </div>
        <div id="footer"></div>
        <script type="text/javascript" src="js/include.js"></script>
</body>
</html>
