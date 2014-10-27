<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<style type="text/css">

</style>
<link href="<%=basePath %>css/login.css" rel="stylesheet">
</head>
<body>
	<div class="top-bar">
		<div id="top-bar-menu-register"  class="top-bar-menu">注册</div>
		<div id="top-bar-menu-login" class="top-bar-menu">登陆</div>
		<div id="top-bar-menu-logout"  class="top-bar-menu">退出</div>
	</div>
	<div class="masking" style="position:absolute;top:0px;left:0px;width:100%;height:100%;z-index:2;display: none;">&nbsp;</div>
	<div class="login-window" style="display:none;">
			<form action="" style="margin-top: 20%; margin-left:30%;margin-right:30%; border:5px solid;background-color: white;">
			<p class="close" style="float: right;cursor: pointer; margin-top:15px; margin-right: 15px; width: 30px;height: 35px;"></p>
			<p align="center">
				<span>用户名：</span><input type="text"  title="用户名">
			</p>
			<p align="center">
				<span>密    码： </span><input type="password" title="密码">
			</p>
			<p align="center">
				<button>登陆</button><button>注册</button>
			</p>
			</form>
	</div>
</body>
<script type="text/javascript" src="<%=basePath %>js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#top-bar-menu-login").bind("click",function(){
			//$("#top-bar-menu-login").removeAttr("display");
			$(".masking").show();
			$(".login-window").show();
			
		});
		$("#top-bar-menu-logout").bind("click",function(){
			alert("退出");
		});
		$(".close").bind("click",function(){
			$(".masking").hide();
			$(".login-window").hide();
			
		});
		
	});
</script>
</html>