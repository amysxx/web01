<%@page import="java.util.Arrays"%>

<%@page import="java.util.List"%>
<%@ page import="bean.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

   <table align="center" border="1px" width="70%">
       <tr>
          <th>ID</th>
          <th>NAME</th>
          <th>AGE</th>
          <th>BIRTHDAY</th>
          <th>COURSE</th>
       </tr>
  <%
     List<Student> list = (List<Student>)request.getAttribute("list");
  
      for(Student s:list){
  %>
      <tr>
         <td><%=s.getId() %></td>
         <td><%=s.getName() %></td>
         <td><%=s.getAge() %></td>
         <td><%=s.getBirthday() %></td>
         <td><%=Arrays.toString(s.getCourse())%></td>
      </tr>
  
  <%} %>
  
  </table>
</body>
</html>