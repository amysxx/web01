<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15566
  Date: 2019/9/1
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% pageContext.setAttribute("str", "aa,bb,ee,mm,tt"); %>
<c:forTokens items="${str }" delims="," var="item">
    ${item }<br />
</c:forTokens>
<c:redirect url="/index.jsp"/>
<jsp:forward page="/index.jsp"/>
</body>
</html>
