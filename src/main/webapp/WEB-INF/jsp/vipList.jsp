<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <title>会员列表</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<!-- 页面显示 -->
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">

            <div class="panel panel-default">
                <div class="panel-heading text-center">
                    <h2>${title}</h2>
                </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <td>会员名字</td>
                            <td>电话号码</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="vip">
                            <tr>
                                <td>${vip.cname}</td>
                                <td>${vip.phone}</td>
                                <td><a class="btn btn-info" href="/vip/${vip.phone}/detail" target="_blank">详情</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="panel-footer" align="center">
                    <ul class="pagination">
                        <li>
                            <a href="#">Prev</a>
                        </li>
                        <li>
                            <a href="#">1</a>
                        </li>
                        <li>
                            <a href="#">2</a>
                        </li>
                        <li>
                            <a href="#">3</a>
                        </li>
                        <li>
                            <a href="#">4</a>
                        </li>
                        <li>
                            <a href="#">5</a>
                        </li>
                        <li>
                            <a href="#">Next</a>
                        </li>
                    </ul>
                </div>
            </div>


        </div>
    </div>
</div>

</body>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
