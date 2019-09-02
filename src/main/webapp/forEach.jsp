<%--
  Created by IntelliJ IDEA.
  User: 15566
  Date: 2019/9/1
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<body>

<%
    List<String> nameList = new ArrayList<String>();
    nameList.add("小德子");
    nameList.add("小格子");
    nameList.add("小桌子");
    nameList.add("小羊子");
    nameList.add("小凳子");
    pageContext.setAttribute("NAMELIST",nameList);
%>
<table border="2" align="center">
    <tr>
        <th>索引</th>
        <th>编号</th>
        <th>姓名</th>
        <th>是第一个元素吗</th>
        <th>是最后个元素吗</th>
    </tr>
    <c:forEach var="xxx" items="${NAMELIST}" varStatus="stat" begin="0" end="2" step="1">
        <tr>
            <td>
                    ${stat.index}
            </td>
            <td>
                    ${stat.count}
            </td>
            <td>
                    ${xxx}
            </td>
            <td>
                    ${stat.first}
            </td>
            <td>
                    ${stat.last}
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>