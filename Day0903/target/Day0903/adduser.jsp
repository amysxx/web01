<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery.js"></script>
<script>
  function checkUsername(){
	  
	  var username = $('#username').val();
	  
	  $.ajax({
		  // 请求路径
		  url:"${pageContext.request.contextPath }/UserServlet",
		  // 要发送给服务器端值
		  //data:"fun=checkusername&username="+username,
		  data:{"fun":"checkusername","username":username},
		  
		  //请求方式，默认为get
	      type:'GET',
	      
	      //回调函数（认为：服务器端响应回来后执行的函数）
	      success:function(data){  // 函数的参数就是服务器端响应回的数据
	    	 
	    	  if(data=='yes'){  //用户名可用
	    		 $('#usernamespan').css('color','green');
	    		 $('#usernamespan').html("√ 用户名可用");
	    		 $('#sub').prop('disabled',false);
	    		  
	    	  }else{
	    		  $('#usernamespan').css('color','red');
		    	  $('#usernamespan').html("× 用户名重复");
		    	  $('#sub').prop('disabled',true);
	    	  }
	      }
	  });
  }
</script>
</head>
<body>
   <form action="${pageContext.request.contextPath }/UserServlet" method="post">
       <input type="hidden" value="add" name="fun" />
       username:<input id="username" type="text" name="username" onblur="checkUsername()" /><span id="usernamespan"></span><br/>
       password:<input type="password" name="password" /><br/>
       age:<input type="text" name="age" /><br/>
       <input type="submit" value=" add " id="sub" />
   </form>
</body>
</html> 