<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

   
   <hr/>
   <h1>
       ${requestScope.requestKey}

   </h1>
    <h1>
       ${sessionScope.sessionKey}
   </h1>
    <h1>
       ${applicationScope.scKey}
   </h1>
   
   <h1>
      ${pageScope.pageKey}
   </h1>
   
   <h1>${scKey }</h1>
   
   <h1>
     <%=request.getAttribute("name") %>
   </h1>
   <h1>${requestScope.name }</h1>
   
   <hr/>
   
   <h1>
        ${requestScope.stu}
   </h1>
   
   <h1>
       ${requestScope.stu.id }---${requestScope.stu["name"] }---${requestScope.stu.age }
   </h1>
   
   <hr/>
    <h1>
       ${requestScope.stringList }---${requestScope.stringList[1]}
    </h1>
    
    <h1>
       ${requestScope.stuList }---${requestScope.stuList[1].name }
    </h1>
    
    <hr/>
    <h1>
       ${requestScope.map }---${requestScope.map.aaa }---${requestScope.map["ccc-c"] }
    </h1>
   
</body>
</html>