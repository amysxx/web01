<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

     <c:if test="${param.msg=='pleaselogin' }">
        <span style="color:red">请登录</span>
     </c:if>

      <form action="${pageContext.request.contextPath }/LoginServlet" method="post">
         username:<input type="text" name="username"/><br>
         password:<input type="password" name="password" /><br />
         <input type="submit" value=" login " />
      </form>
</body>
</html>