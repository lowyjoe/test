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
<link rel="stylesheet" href="oschinaMenu/metisMenu.css">
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script src="oschinaMenu/bootstrap.min.js"></script>
<script src="oschinaMenu/metisMenu.js"></script>
</head>
<body>
	<div id="testM">
	<ul >
        <li>
            <a href="#none">衬衫</a>
            <ul >
                <li><a href="#none">短袖衬衫</a></li>
                <li><a href="#none">长袖衬衫</a></li>
                <li><a href="#none">短袖T恤</a></li>
                <li><a href="#none">长袖T恤</a></li>
            </ul>
        </li>
        <li >
            <a href="#none">卫衣</a>
            <ul >
                <li><a href="#none">开襟卫衣</a></li>
                <li><a href="#none">套头卫衣</a></li>
                <li><a href="#none">运动卫衣</a></li>
                <li><a href="#none">童装卫衣</a></li>
            </ul>
        </li>
        <li >
            <a href="#none">裤子</a>
            <ul >
                <li><a href="#none">短裤</a></li>
                <li><a href="#none">休闲裤</a></li>
                <li><a href="#none">牛仔裤</a></li>
                <li><a href="#none">免烫卡其裤</a></li>
            </ul>
        </li>
    </ul>
    
</div>
</body>
<script type="text/javascript">
 	$("#testM").metisMenu();
</script>
</html>