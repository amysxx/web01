<%--
  Created by IntelliJ IDEA.
  User: 15566
  Date: 2019/8/28
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载界面</title>
</head>
<body>
<a href="download/amy.txt">下载amy.txt</a>
<a href="download/01.jpg">下载01.jpg</a>
<a href="download/01.zip">下载01.zip</a>
<hr/>

<a href="downloadServlet?filename=amy.txt">下载amy.txt</a>
<a href="downloadServlet?filename=01.jpg">下载01.jpg</a>
<a href="downloadServlet?filename=01.zip">下载01.zip</a>
<a href="downloadServlet?filename=中文.txt">下载-中文.txt</a>
</body>
</html>
