<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<% 
		String path = request.getContextPath(); 
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	System.out.print(basePath);
		%> 
	<base href="<%=basePath %>">
		<title>主页</title>
		<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/jquery-pop-window.js"></script>
		<link rel="stylesheet" type="text/css" href="css/manhuaDialog.1.0.css">
<script type="text/javascript">

$(function (){
	$("#test").manhuaDialog({					       
		Event : "click",								//触发响应事件
		title : "漫画弹出层插件测试",					//弹出层的标题
		type : "id",									//弹出层类型(text、容器ID、URL、Iframe)
		content : "detail",								//弹出层的内容获取(text文本、容器ID名称、URL地址、Iframe的地址)
		width : 500,									//弹出层的宽度
		height : 300,									//弹出层的高度	
		scrollTop : 200,								//层滑动的高度也就是弹出层时离顶部滑动的距离
		isAuto : true,									//是否自动弹出
		time : 2000,									//设置弹出层时间，前提是isAuto=true
		isClose : false,  								//是否自动关闭		
		timeOut : 5000									//设置自动关闭时间，前提是isClose=true	
	});
});
</script>
	</head>
	
	<body>
	<script type="text/javascript">
	alert($("test").href());
	</script>
		<a href="javascript:void(0)" id="test">漫画弹出层插件测试</a>
	</body>
	
</html>