<%@ page language="java" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>Untitled Page</title>
<link rel="stylesheet" href="css/easyui/themes/default/easyui.css" />
<link rel="stylesheet" href="css/easyui/themes/icon.css" />
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/yibushueasyui.js"></script>
</head>
</head>

<body>
	<div id="mm" class="easyui-menu"  >
		<div id="append" onclick="append()" data-options="iconCls:'edit_add'">追加兄弟节点</div>
		<div id="edite" onclick="edite();" data-options="iconCls:'edit_remove'">修改</div>
		<div onclick="shanchu()">移除</div>
	</div>
	<div id="mydialog"
		style="display: none; ">
		<div>
			<label>菜单名称:</label> <input name="text" id="text" >
		</div>
	</div>
	<input id="ss" class="easyui-searchbox" style="width: 300px"
		data-options="searcher:search,prompt:'Please Input Value'"></input>

	<div style="width: 150px;">
		<ul id="tt">
		</ul>
	</div>
</body>
</html>
