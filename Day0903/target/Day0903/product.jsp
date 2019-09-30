<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery.js"></script>
<script>

  /* function searchWord(obj){
	   var word = $(obj).val();
	   
	   $.post('${pageContext.request.contextPath}/0903/ProductServlet',{'word':word},function(data){
		  
		   var str = "";
		   
		 /!*   if(data!==''){ *!/
			   var objs = eval("("+data+")");//如果data为空字符串这句话会在页面中f12报错,因为缓存的问题
			   
			   for(var i=0;i<objs.length;i++){
				   str = str+"<div onclick='xuanze(this)' onmouseover='xuanzhong(this)' onmouseout='likai(this)'>"+objs[i].name+"</div>";
			   }
		/!*    } *!/
		   
		   $('#show').html(str);
		   $('#show').show();
	   });
	   
   }*/
   $(function () {
       $("#productName").keyup(function () {

           var word = $(this).val();


           $.post('${pageContext.request.contextPath}/0903/ProductServlet',{'word':word},function(data){

               var str = "";

               /*   if(data!==''){ */
               var objs = eval("("+data+")");//如果data为空字符串这句话会在页面中f12报错,因为缓存的问题

               for(var i=0;i<objs.length;i++){
                   str = str+"<div onclick='xuanze(this)' onmouseover='xuanzhong(this)' onmouseout='likai(this)'>"+objs[i].name+"</div>";
               }
               /*    } */

               $('#show').html(str);
               $('#show').show();
           });
       })

   })
   function xuanze(obj){
	   var word = $(obj).html();
	   $('#productName').val(word);
	   $('#show').hide();
	   
   }
   
   function xuanzhong(obj){
	   $(obj).css('backgroundColor','blue');
	   $(obj).css('cursor','pointer');
   }
   
   function likai(obj){
	   $(obj).css('backgroundColor','');
	   $(obj).css('cursor','');
   }

</script>
</head>
<body>
   <form>
      <input type="text" id="productName" name="productName" style="width:200px" />
      <input type="submit" value=" search " /> 
      <div id="show" style="width:200px;border:1px green solid"></div>
   </form>
</body>
</html>