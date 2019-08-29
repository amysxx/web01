<%--
  Created by IntelliJ IDEA.
  User: 15566
  Date: 2019/8/26
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
</head>

<body>
<html>

<head>
    <title>登录界面</title>
    <meta charset="UTF-8">
</head>

<body>
<form action="IndexServlet" method="post">
    <table border="0px" cellspacing="0px" cellpadding="0px">
        <tr>
            <th>username:<input type="text" name="username" ></th>
        </tr>
        <tr>
            <th>password:<input type="password" name="password" ></th>
        </tr>
        <tr>
            <td>sex:<input type="radio" name="sex" value="男" >男<input type="radio" name="sex" value="女" >女</td>
        </tr>
        <tr>
            <td>age:<input type="text" name="age"></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="注册"></td>
        </tr>

    </table>

</form>
</body>

</html>

</body>

</html>