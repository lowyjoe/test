<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<% 
	String path = request.getContextPath(); 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	System.out.print(basePath);
%> 
<base href="<%=basePath %>">
<title>信息查询界面</title>
<link rel="stylesheet" type="text/css" href="css/easyui/themes/default/easyui.css">
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
</head>
<body>
    <h2>Custom DataGrid Pager</h2>
    <p>You can append some buttons to the standard datagrid pager bar.</p>
    <div style="margin:20px 0;"></div>
    <table id="dg" title="Custom DataGrid Pager" style="width:700px;height:250px"
            data-options="rownumbers:true,singleSelect:true,pagination:true,url:'datagrid_data1.json',method:'get'">
        <thead>
            <tr>    
             	<!-- <th data-options="field:'itemid',width:80">Item ID</th>
                <th data-options="field:'productid',width:100">Product</th>
                <th data-options="field:'listprice',width:80,align:'right'">List Price</th>
                <th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
                <th data-options="field:'attr1',width:240">Attribute</th>
                <th data-options="field:'status',width:60,align:'center'">Status</th> -->
                
                <th data-options="field:'unknow1',width:80">unknow1</th>
                <th data-options="field:'name',width:100">姓名</th>
                <th data-options="field:'ctfid',width:80,align:'right'">身份证</th>
                <th data-options="field:'gender',width:80,align:'right'">性别</th>
                <th data-options="field:'birthday',width:240">出生日期</th>
                <th data-options="field:'address',width:60,align:'center'">地址</th>
                <th data-options="field:'mobile',width:60,align:'center'">手机</th>
                <th data-options="field:'tel',width:60,align:'center'">座机</th>
                <th data-options="field:'fax',width:60,align:'center'">传真</th>
            </tr>
        </thead>
    </table>
    <script type="text/javascript">
        $(function(){
            var pager = $('#dg').datagrid().datagrid('getPager');    // get the pager of datagrid
            pager.pagination({
                buttons:[{
                    iconCls:'icon-search',
                    handler:function(){
                        alert('search');
                    }
                },{
                    iconCls:'icon-add',
                    handler:function(){
                        alert('add');
                    }
                },{
                    iconCls:'icon-edit',
                    handler:function(){
                        alert('edit');
                    }
                }]
            });            
        })
    </script>
</body>
</html>