<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Index</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
  </head>
  
  <body>
  	<a href="upload.html">图片上传</a><br>
    <a href="category-update.action">update</a><br>
    <a href="${pageContext.request.contextPath}/category-save.action">save</a><br>
    <a href="category-query.action">查询所有类别</a><br>
    <a href="category-update.action?id=1&type=男士服装&hot=true">ModelDriven测试</a><br>
    <a href="category-getjson.action">JSON格式</a>
    <hr>
    Request<br>
    <c:forEach items="${requestScope.categoryList}" var="category">
    	${category.id} | ${category.type } | ${category.hot} <br>
    </c:forEach>
    <hr>
    Session<br>
    <c:forEach items="${sessionScope.categoryList}" var="category">
    	${category.id} | ${category.type } | ${category.hot} <br>
    </c:forEach>
    <hr>
    Application<br>
    <c:forEach items="${applicationScope.categoryList}" var="category">
    	${category.id} | ${category.type } | ${category.hot} <br>
    </c:forEach>
    <hr>
    Listener<br>
    <c:forEach items="${applicationScope.list}" var="item">
    	${item.id} --- ${item.type } --- ${item.hot }<br>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/confirm/confirm.html">用户验证</a>
  </body>
</html>
