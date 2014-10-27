<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>TOP</title>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<style type="text/css">
.top-bar{
background-image: url("../lim-imgs/top-bar1.jpg");
margin-top:2px;
margin-left:2px;
margin-right:2px;
height: 66px;
width: 1340px;
z-index: 1;
}
.top-bar-menu{
	float: right;
	margin-right: 100px;
	margin-top: 20px;
	color: red;
	font-size: 22px;
	font-weight: bolder; 
	cursor: pointer;
	z-index: 1;
}
.top-bar-menu-logout{
float: right;
}
</style>
</head>
<body>
	<div class="top-bar">
		<div id="top-bar-menu-register"  class="top-bar-menu">注册</div>
		<div id="top-bar-menu-login" class="top-bar-menu">登陆</div>
		<div id="top-bar-menu-logout"  class="top-bar-menu">退出</div>
	</div>
</body>
</html>