<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="./css/style.css"  />
    <script src="./js/My97DatePicker/WdatePicker.js"></script>
    <script src="./js/jquery.js"></script>

</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">商品管理</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">

            <!--

            <li class="click"><span><img src="images/t02.png" /></span>修改</li>
            <li><span><img src="images/t04.png" /></span>统计</li>
             -->
            <li style="cursor: pointer;" id="addProduct" ><span><img src="img/t01.png"  /></span>添加商品</li>
            <li style="cursor: pointer;" onclick="delBatch()"><span><img src="img/t03.png" /></span>批量删除</li>
        </ul>

    </div>


    <table class="tablelist">
        <thead>
        <tr>
            <th><input name="" type="checkbox" value="" id="checkall" onclick="checkAll()" /></th>
            <th>序号<i class="sort"><img src="img/px.gif" /></i></th>
            <th>商品类别</th>
            <th>商品名称</th>
            <th>商品颜色</th>
            <th>商品价格</th>
            <th width="10%">简介</th>
            <th>商品展示图</th>
            <th>是否热推</th>
            <th>型号</th>
            <th>生产日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.list }" var="p" varStatus="num">
            <tr>
                <td><input name="" type="checkbox" value="${p.id }"/></td>
                <td>${num.count }</td>
                <td>${p.category.categoryName }</td>
                <td>${p.name }</td>
                <td>${p.color }</td>
                <td>${p.price }</td>
                <td width="10%">${p.introduction }</td>
                <td>
                    <img src="${pageContext.request.contextPath }/upload/${p.image}" alt="" width="80" height="40" />
                </td>
                <td>
                    <!-- 0 正常,1热门产品，2为你推荐，3，新品 4，小米明星单品 -->
                    <c:if test="${p.state==0 }">正常</c:if>
                    <c:if test="${p.state==1 }">热门产品</c:if>
                    <c:if test="${p.state==2 }">为你推荐</c:if>
                    <c:if test="${p.state==3 }">新品</c:if>
                    <c:if test="${p.state==4 }">小米明星单品</c:if>
                </td>
                <td>${p.version }</td>
                <td>${p.birthday }</td>
                <td>
                    <a href="javascript:delProduct('${p.id }')">删除</a>
                    <a href="javascript:modifyProduct('${p.id }')">修改</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</div>

<script>

    function modifyProduct(id){
        location = "${pageContext.request.contextPath}/Product2Servlet?fun=preModifyProduct&id="+id;
    }




    function delProduct(id){

        if(window.confirm('确定删除吗？')){
            window.location.href="${pageContext.request.contextPath}/Product2Servlet?fun=delProduct&id="+id;
        }

    }

    function checkAll(){

        var flag = $('#checkall').prop('checked');

        if(flag){
            $(':checkbox').not('#checkall').prop('checked',true);
        }else{
            $(':checkbox').not('#checkall').prop('checked',false);
        }
    }

    function delBatch(){

        var flag = false;

        var cs = $(':checkbox').not('#checkall')

        cs.each(function(){
            if($(this).prop('checked')==true){
                flag = true;
            }
        });

        var ids = '';

        if(flag){  // 表示有选中的
            if(confirm("确定删除吗？")){
                cs.each(function(){
                    if($(this).prop('checked')==true){
                        ids = ids+$(this).val()+",";
                    }
                });
                location="Product2Servlet?fun=delBatch&ids="+ids;
            }
        }else{
            alert("请选择要删除的商品");
        }

    }

</script>

</body>
</html>