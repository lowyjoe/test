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
/* reset */
body{margin:0;padding:0 0 12px 0;font-size:12px;line-height:22px;font-family:"\5b8b\4f53","Arial Narrow";background:#fff;}
form,ul,li,p,h1,h2,h3,h4,h5,h6{margin:0;padding:0;}
input,select{font-size:12px;line-height:16px;}
img{border:0;}
ul,li{list-style-type:none;}
a {color:#00007F;text-decoration:none;}
a:hover {color:#bd0a01;text-decoration:underline;}
.box {
    width: 150px;
    margin: 0 auto;
}
.menu{
    overflow:hidden;
    border-color: #C4D5DF;
    border-style: solid;
    border-width: 0 1px 1px;
}
/* lv1 */
.menu li.level1 a{
    display: block;
    height: 28px;
    line-height: 28px;
    background:#EBF3F8;
    font-weight:700;
    color: #5893B7;
    text-indent: 14px;
    border-top: 1px solid #C4D5DF;
}
.menu li.level1 a:hover{text-decoration:none;}
.menu li.level1 a.current{background:#B1D7EF;}
/* lv2 */
.menu li ul{overflow:hidden;}
.menu li ul.level2{display:none;}
.menu li ul.level2 li a{
    display: block;
    height: 28px;
    line-height: 28px;
    background:#ffffff;
    font-weight:400;
    color: #42556B;
    text-indent: 18px;
    border-top: 0px solid #ffffff;
    overflow: hidden;
}
.menu li ul.level2 li a:hover{
    color:#f60;
}
</style>
</head>
<body>
	<div class="box">
    <ul class="menu">
        <li class="level1">
            <a href="#none">衬衫</a>
            <ul class="level2">
                <li><a href="#none">短袖衬衫</a></li>
                <li><a href="#none">长袖衬衫</a></li>
                <li><a href="#none">短袖T恤</a></li>
                <li><a href="#none">长袖T恤</a></li>
            </ul>
        </li>
        <li class="level1">
            <a href="#none">卫衣</a>
            <ul class="level2">
                <li><a href="#none">开襟卫衣</a></li>
                <li><a href="#none">套头卫衣</a></li>
                <li><a href="#none">运动卫衣</a></li>
                <li><a href="#none">童装卫衣</a></li>
            </ul>
        </li>
        <li class="level1">
            <a href="#none">裤子</a>
            <ul class="level2">
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
$(document).ready(function(){
    $(".level1 > a").click(function(){
        $(this).addClass("current")   //给当前元素添加"current"样式
        .next().show()                //下一个元素显示
        .parent().siblings().children("a").removeClass("current")        //父元素的兄弟元素的子元素<a>移除"current"样式
        .next().hide();                //它们的下一个元素隐藏
        return false;
    });
});
</script>
</html>