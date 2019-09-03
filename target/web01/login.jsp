<%--
  Created by IntelliJ IDEA.
  User: 15566
  Date: 2019/8/27
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<script tpye="text/html">
    function changeImage(){
        document.getElementById("checkImage").src="CheckCodeServlet?random="+Math.random();
    }
</script>
</html>
<body>
<form action="StudentServlet" method="post">
    <input type="hidden" name="fun" value="findAll"/>
    用户名:<input type="text" name="username"/><br/>
    密码:<input type="password" name="password"/><br/>
    验证码:<input type="text" /><img src="CheckCodeServlet" id="checkImage" /><a href="javascript:changeImage()">看不清，换一张</a><br/>
    <input type="submit" value="登录"/>
</form>
</body>


</body>
</html>
