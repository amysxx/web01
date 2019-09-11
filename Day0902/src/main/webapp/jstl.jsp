<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>c:if标签</h1>
   
   <c:if test="${requestScope.stu.age>20 }">
      可以进入
   </c:if>
   
   <c:choose>
      <c:when test="${requestScope.stu.name=='李四' }">
          当皇帝
      </c:when>
      <c:otherwise>
          当太上皇   
      </c:otherwise>
   </c:choose>
   



   <h1> 遍历存放String的list</h1>
   <c:forEach items="${requestScope.stringList}" var="str" varStatus="aaa">
      ${str }---${aaa.index }---${aaa.count }<br/>
   </c:forEach>
   
   <hr/>
   <h1>遍历存放Student的list</h1>
   <c:forEach items="${requestScope.stuList }" var="stu" varStatus="aaa">
       ${stu.id }---${stu.name }---${stu.age }---${aaa.index } <br/>
   </c:forEach>
   <hr/>
   <h1>遍历存放int的数组</h1>
   <c:forEach items="${requestScope.aa }" var="x">
       ${x }<br/>
   </c:forEach>
   
   <hr/>
   <h1>遍历存放Student的数组</h1>
   <c:forEach items="${requestScope.stus }" var="stu">
       ${stu.id }---${stu.name }---${stu.age }<br/><br/>
   </c:forEach>
   
   <hr/>
   <h1>遍历存放String String的map</h1>
   <c:forEach items="${requestScope.map }" var="mm">
       ${mm}---${mm.key }---${mm.value }<br/><br/>
   </c:forEach>
   
   <hr/>
   <h1>遍历存放String Student的map</h1>
   <c:forEach items="${requestScope.stuMap }" var="stumm">
       ${stumm.key }---${stumm.value.id }---${stumm.value.name }---${stumm.value.age }<br/>
   </c:forEach>
   
   <hr/>
   
   <c:forEach begin="1" end="100" step="3" var="num">
      ${num }---
   </c:forEach>
   <hr/>
   
   <h1>${requestScope.now }</h1>
   <h1>
      <fmt:formatDate value="${requestScope.now }" pattern="yyyy-MM-dd HH:mm:ss" />
   </h1>
</body>
</html>