<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/js/jquery-1.8.0.min.js"></script>
<title >polling test</title>
</head>
<body>
<div id="message"></div>
</body>
<script type="text/javascript">
    var updater = {
    poll: function(){
        $.ajax({url: "../kxgk/gzAlla.do", 
                type: "POST", 
                dataType: "text",
                success: updater.onSuccess,
                error: updater.onError});
    },
    onSuccess: function(data, dataStatus){
        try{
            $("#message").append(data);
        }
        catch(e){
            updater.onError();
            return;
        }
        interval = window.setTimeout(updater.poll, 0);
    },
    onError: function(){
        console.log("Poll error;");
    }
};
updater.poll();
</script>
</html>