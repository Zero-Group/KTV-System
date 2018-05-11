<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>KTV管理系统</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<!-- 页面显示 -->

<%@include file="common/navbar.jsp"%>

<div class="main-container" id="main-container">

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <div class="sidebar" id="sidebar">

            <ul class="nav nav-list">
                <li class="active">
                    <a href="<c:url value="/room"/>">
                        <i class="icon-home"></i>
                        <span class="menu-text">房间管理</span>
                    </a>
                </li>

                <li>
                    <a href="<c:url value="/vip"/>">
                        <i class="icon-text-width"></i>
                        <span class="menu-text">会员管理</span>
                    </a>
                </li>

                <li>
                    <a href="<c:url value="/account"/>">
                        <i class="icon-text-width"></i>
                        <span class="menu-text">账目管理</span>
                    </a>
                </li>

            </ul><!-- /.nav-list -->

        </div>

        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="<c:url value="/ktv"/>">主页</a>
                    </li>

                    <li>
                        <a href="<c:url value="/room"/>">房间管理</a>
                    </li>
                    <li class="active">所有房间</li>
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div><!-- /.main-content -->
    </div><!-- /.main-container-inner -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

</body>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
