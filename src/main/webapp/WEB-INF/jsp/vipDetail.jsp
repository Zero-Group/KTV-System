<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>会员详情</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<!-- 页面显示 -->
<div class="container">
    <div class="panel panel-default text-center">
        <div class="panel-heading text-center">
            <h2>${title}</h2>
        </div>
        <div class="panel-body">
            ${vip.cname} ${vip.phone}
        </div>
    </div>
</div>
</body>
</html>
