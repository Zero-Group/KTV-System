<%--
  Created by IntelliJ IDEA.
  User: lixinheng
  Date: 2018/5/14
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>查询房间</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<!-- 页面显示 -->
<%@include file="common/navbar.jsp" %>

<div class="main-container" id="main-container">

    <div class="main-container-inner">

        <div class="sidebar" id="sidebar">

            <ul class="nav nav-list">
                <li class="active">
                    <a href="<c:url value="/room"/>" class="dropdown-toggle">
                        <i class="icon-home"></i>
                        <span class="menu-text">房间管理</span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="<c:url value="/room/all"/>">
                                <i class="icon-list-ul"></i>
                                所有房间
                            </a>
                        </li>

                        <li class="active">
                            <a href="<c:url value="/room/query"/>">
                                <i class="icon-search"></i>
                                查询房间
                            </a>
                        </li>

                        <li>
                            <a href="<c:url value="/room/add"/>">
                                <i class="icon-plus"></i>
                                新增房间
                            </a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="<c:url value="/vip"/>">
                        <i class="icon-user"></i>
                        <span class="menu-text">会员管理</span>

                        <b class="arrow icon-angle-down"></b>
                    </a>
                </li>

                <li>
                    <a href="<c:url value="/account"/>">
                        <i class="icon-bar-chart"></i>
                        <span class="menu-text">账目管理</span>

                        <b class="arrow icon-angle-down"></b>
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
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="row">
                            <div class="col-xs-12 center">
                                <div class="well-lg blue">
                                    <h1>查询房间</h1>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-4"></div>
                            <div class="col-xs-12 col-sm-4">
                                <div class="alert alert-info">
                                    <strong>提示：</strong><br>
                                    输入房间号可查询该房间，输入“空”可查询所有空房间，输入“空”加房间类型可查询该类型的空房间
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-4"></div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-4"></div>
                            <div class="col-xs-12 col-sm-4">
                                <form class="form-search" action="<c:url value="/room/query"/>" method="post">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="input-group">
                                                <input type="text" name="key" class="form-control search-query"
                                                       placeholder="请按照提示输入..."/>
                                                <span class="input-group-btn">
                                                    <button type="submit" class="btn btn-info btn-sm">
                                                        搜索
                                                        <i class="icon-search icon-on-right bigger-110"></i>
                                                    </button>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="col-xs-12 col-sm-4"></div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12 center">
                                <div class="center red">
                                    ${msg}
                                </div>
                            </div>
                        </div>

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

<!-- basic scripts -->

<!--[if !IE]> -->
<script src="https://cdn.bootcss.com/jquery/2.0.3/jquery.min.js"></script>
<!-- <![endif]-->

<!--[if IE]>
<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='/assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");
</script>
<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='/assets/js/jquery-1.10.2.min.js'>" + "<" + "/script>");
</script>
<![endif]-->

<script type="text/javascript">
    if ("ontouchend" in document) document.write("<script src='/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/assets/js/typeahead-bs2.min.js"/>"></script>

<!-- page specific plugin scripts -->

<!-- ace scripts -->
<script src="<c:url value="/assets/js/ace-elements.min.js"/>"></script>
<script src="<c:url value="/assets/js/ace.min.js"/>"></script>

</html>
