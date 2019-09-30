<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%=request.getParameter("name") %>
   <h1>${param.name }</h1>
   <h1>${paramValues.course[0]}--${paramValues.course[1]}--${paramValues.course[2]}</h1>
   <h1>${header["User-Agent"] }</h1>
   <h1>${initParam.pname}</h1>
   <h1>${cookie.cname}</h1>
   <h1>${cookie.cname.name}---${cookie.cname.value}</h1>
   <h1>${pageContext.request.contextPath }</h1>
   <h1>${pageContext.request.protocol }</h1>
   <h1>${pageContext.request.method }</h1>
</body>
</html>