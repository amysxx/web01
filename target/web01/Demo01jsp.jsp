<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="Demo02jsp.domain.User" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15566
  Date: 2019/9/1
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setAttribute("a",10);
%>
<c:if test="${requestScope.a>8}">
    <h1>a的值 大于8</h1>
</c:if>
<%
    String[] arr = {"123", "456", "789"};
    pageContext.setAttribute("arr", arr, PageContext.REQUEST_SCOPE);
%>
${requestScope.arr[0]}


<%
    pageContext.setAttribute("NAME","哈哈");
%>
姓名：${NAME}<br/>
<hr/>
<%
    User user = new User(2015,"呵呵",10000D);
    request.setAttribute("USER",user);
%>
编号：${USER.id}<br/>
姓名：${USER.name}<br/><!--自动调用getter方法-->
薪水：${USER.sal}<br/>
<hr/>
<%
    List<String> nameList = new ArrayList<String> ();
    nameList.add("A");
    nameList.add("B");
    nameList.add("C");
    session.setAttribute("NAMELIST",nameList);
%>
第二个元素是：${NAMELIST[1]}<br/>
<hr/>
<%
    Map<String,Integer> map = new LinkedHashMap<String,Integer> ();
    map.put("jack",10000);
    map.put("marry",12000);
    map.put("sisi",14000);
    application.setAttribute("MAP",map);
%>
SISI的工资是：${MAP['sisi']}<br/>
<hr/>
<%
    String[] strArray = {"北京","上海","广州","深圳"};
    pageContext.setAttribute("STRARRAY",strArray);
%>
你目前所在的城市是：${STRARRAY[2]}<br/>
<hr/>
姓名：${NAMEE}<br/>

</body>
</html>
