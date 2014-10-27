<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试Iframe</title>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<style type="text/css">
</style>
</head>
 <frameset rows="74px,*,10%" framespacing="0" >
	 	<frame name="top" src="top.jsp" scrolling="no"  frameborder="0" noresize="noresize"></frame>
	 	<frameset  cols="10%,*"  >
	 		<frame  name="main-left"  src="main_left.jsp" frameborder="0" noresize="noresize" ></frame>
			<frame name="mai-right" src="main_right.jsp" frameborder="0"   noresize="noresize" ></frame>
	 	</frameset>
	<frame name="bottom" scrolling="no" frameborder="0" noresize="noresize" src="bottom.jsp" ></frame>
</frameset>
<script type="text/javascript">

</script>
</html>