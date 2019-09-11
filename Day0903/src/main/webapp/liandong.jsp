<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery.js"></script>
<script>
      $(function(){
    	  //$.post();
    	  $.get('${pageContext.request.contextPath}/0903/TestServlet',{'fun':'findAllCountry'},function(data){
    		  
    		  //{"countryList":[{"cityList":[],"id":1,"name":"中国"},{"cityList":[],"id":2,"name":"美国"},{"cityList":[],"id":3,"name":"日本"}]}
              var obj=JSON.parse(data);
    		  //var obj = eval("("+data+")");
    		  var countries = obj.countryList;
    		
    		  var str = "";
    		  
    		  for(var i=0;i<countries.length;i++){
    			  str = str+"<option value='"+countries[i].id+"'>"+countries[i].name+"</option>";
    		  }
    		  
    		  $('#country').html($('#country').html()+str);
    	  });
    	  
    	  //------------------------------------------
          //改变事件
    	  $('#country').change(function(){
    	      //获得select的value
    		  var countryId = $(this).val();
    		  
    		  $.getJSON('${pageContext.request.contextPath}/0903/TestServlet',{'fun':'findCityByCountryId','countryId':countryId},function(data){
    			  
    			  var cities = data.cityList;
    			  
    			  if(cities.length==0){
    				  //设置html代码
    				  $('#city').html("<option value='0'>请选择</option>");
    				  
    			  }else{
    				  
    				  var str = "";
            		  
            		  for(var i=0;i<cities.length;i++){
            			  str = str+"<option value='"+cities[i].id+"'>"+cities[i].name+"</option>";
            		  }
            		  
            		  //$('#city').html(str);
                      //$("select option[value='0']").remove();
                      $("select option:first-child").remove();
    				  $('#city').append(str);
    			  }
    		  });
    		  
    	  });
    	  
    	  
      });
</script>
</head>
<body>
  <select id="country">
     <option value="0">请选择</option>
  </select>
  <select id="city">
     <option value="0">请选择</option>
  </select>
</body>
</html>