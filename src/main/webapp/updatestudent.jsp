<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Date" %>
<%@ page import="bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: 15566
  Date: 2019/8/30
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>更改学生信息</title>
</head>
<body>
<%  Student s = (Student) request.getAttribute ("stu");
    int id = s.getId();
    String name = s.getName();
    int age = s.getAge();
    Date birthday = s.getBirthday();
    String course = Arrays.toString(s.getCourse ());%>
<form action="StudentServlet?fun=update&id=<%=id%>" method="post">
    id:<input type="text" name="id" value="<%=id%>"/><br />
    name:<input type="text" name="name" value="<%=name%>"/><br />
    age:<input type="text" name="age" value="<%=age%>"/><br />
    birthday:<input type="text" name="birthday" value="<%=birthday%>"/><br />
    course:<input type="text" name="course" value="<%=course%>"/><br />
    <input type="submit" value="submit"/>

</form>
</body>
</html>
