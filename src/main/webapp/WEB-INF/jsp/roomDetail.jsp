<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>房间详情</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<!-- 页面显示 -->
<div class="container">
    <div class="panel panel-default text-center">
        <div class="panel-heading text-center">
            <h2>${title}</h2>
        </div>
    </div>
    <div class="panel-body">
        ${room.type} ${room.id}
    </div>
</div>
</body>
</html>
