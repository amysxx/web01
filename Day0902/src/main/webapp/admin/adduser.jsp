
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="${pageContext.request.contextPath }/admin/UserServlet" method="post">
     username:<input type="text" name="username" /><br/>
     password:<input type="password" name="password" /><br/>
     age:<input type="text" name="age" /><br/>
     <input type="submit" value=" submit "/>
  </form>
</body>
</html>