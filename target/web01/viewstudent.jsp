<%@page import="java.util.Arrays"%>

<%@page import="java.util.List"%>
<%@ page import="bean.Student" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视图界面</title>

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

         <% int id = s.getId();
         String name = s.getName();
         int age = s.getAge();
         Date birthday = s.getBirthday();
         String course = Arrays.toString(s.getCourse ());%>
         <td><%=id%></td>
         <td><%=name %></td>
         <td><%=age %></td>
         <td><%=birthday %></td>
         <td><%=course%></td>
         <td><input type="button" name="delete" value="删除" onclick="del(<%=id%>)">&nbsp;&nbsp;
             <input type="button" name="update" value="修改" onclick="query(<%=id%>)"></td>
      </tr>
  
  <%} %>
  
  </table>
</body>
<script>
    function del(id) {
        location="<%=request.getContextPath()%>"+"/StudentServlet?fun=query&id="+id;
    };

    function query(id) {
        location="<%=request.getContextPath()%>"+"/StudentServlet?fun=query&id="+id;
    }
</script>
</html>