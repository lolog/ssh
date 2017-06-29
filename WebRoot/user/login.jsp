<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Login</title>
  </head>
  
  <body>
  	错误信息：${sessionScope.error}
  	<hr>
    <form action="confirm-login.action" method="POST">
    	<input type="text" name="type"><br>
    	<input type="submit" value="login">
    </form>
  </body>
</html>
