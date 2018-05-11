<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <title>房间列表</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<!-- 页面显示 -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>${title}</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>编号</td>
                    <td>类型</td>
                    <td>状态</td>
                    <td>开始时间</td>
                    <td>结束时间</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="room">
                    <tr>
                        <td>${room.id}</td>
                        <td>${room.type}</td>
                        <td>${room.status}</td>
                        <td>
                            <fmt:formatDate value="${room.startTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                        </td>
                        <td>
                            <fmt:formatDate value="${room.endTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                        </td>
                        <td><a class="btn btn-info" href="/room/${room.type}-${room.id}/detail" target="_blank">详情</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
