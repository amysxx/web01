<%@ page import="offcn_el_jstl.bean.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   ${10+2}--${10/2 }---${5==5 }---${5<3 }
   <hr/>
   
   <%
    Student stu = new Student(1,"张三",20);
    Student stu2 = new Student(2,"李四",20);
   
    request.setAttribute("stu",stu);
    request.setAttribute("stu2",stu2);
   %>
   
   ${requestScope.stu.name=="张三" }--
   ${requestScope.stu.age==22 }###
   
   ${requestScope.stu.age eq requestScope.stu2.age }###
   
   ${5==5 and 3<1 }
   
</body>
</html>