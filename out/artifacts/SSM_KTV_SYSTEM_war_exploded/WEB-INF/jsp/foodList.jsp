<%--
  Created by IntelliJ IDEA.
  User: lijinzhu
  Date: 2018/5/14
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>食物列表</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<!-- 页面显示 -->
<%@include file="common/navbar.jsp" %>

<div class="main-container" id="main-container">

    <div class="main-container-inner">

        <div class="sidebar" id="sidebar">

            <ul class="nav nav-list">
                <li>
                    <a href="<c:url value="/room"/>">
                        <i class="icon-home"></i>
                        <span class="menu-text">房间管理</span>

                        <b class="arrow icon-angle-down"></b>
                    </a>
                </li>

                <li>
                    <a href="<c:url value="/vip"/>">
                        <i class="icon-user"></i>
                        <span class="menu-text">会员管理</span>

                        <b class="arrow icon-angle-down"></b>
                    </a>
                </li>

                <li class="active">
                    <a href="<c:url value="/account"/>" class="dropdown-toggle">
                        <i class="icon-bar-chart"></i>
                        <span class="menu-text">账目管理</span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li class="active">
                            <a href="<c:url value="/account/food"/>" class="dropdown-toggle">
                                <i class="icon-food"></i>
                                食物管理
                                <b class="arrow icon-angle-down"></b>
                            </a>

                            <ul class="submenu">
                                <li>
                                    <a href="<c:url value="/account/food/all"/>">
                                        <i class="icon-list-ul"></i>
                                        所有食物
                                    </a>
                                </li>

                                <li>
                                    <a href="<c:url value="/account/food/query"/>" class="dropdown-toggle">
                                        <i class="icon-search"></i>
                                        查询食物
                                    </a>
                                </li>
                                <li>
                                    <a href="<c:url value="/account/food/add"/>" class="dropdown-toggle">
                                        <i class="icon-plus"></i>
                                        新增食物
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <li>
                            <a href="<c:url value="/account/order"/>">
                                <i class="icon-money"></i>
                                订单管理
                                <b class="arrow icon-angle-down"></b>
                            </a>
                        </li>
                    </ul>
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
                        <a href="<c:url value="/account"/>">账目管理</a>
                    </li>
                    <li>
                        <a href="<c:url value="/account/food"/>">食物管理</a>
                    </li>
                    <li class="active">${title}</li>
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <c:forEach var="i" begin="1" end="${rows}">
                            <div class="row">
                                <c:forEach items="${list}" var="food" begin="${6*(i-1)}" end="${6*(i-1)+5}">
                                    <div class="col-xs-12 col-sm-2 widget-container-span ui-sortable">
                                        <a href="/account/food/id=${food.id}/detail" style="text-decoration: none;">
                                            <div class="widget-box" style="opacity: 1;">
                                                <div class="widget-header">
                                                    <h4 class="grey">${food.fname}</h4>

                                                    <div class="widget-toolbar">
                                                        <span class="label label-info">${food.stock}份</span>
                                                    </div>
                                                </div>

                                                <div class="widget-body">
                                                    <div class="widget-main padding-2">
                                                        <div class="alert alert-info">价格：<br>${food.price}元/份<br><br>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                            <br>
                        </c:forEach>

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
    window.jQuery || document.write("<script src='https://cdn.bootcss.com/jquery/2.0.3/jquery.min.js'>" + "<" + "/script>");
</script>
<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js'>" + "<" + "/script>");
</script>
<![endif]-->

<script type="text/javascript">
    if ("ontouchend" in document) document.write("<script src='/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="https://cdn.bootcss.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="<c:url value="/assets/js/typeahead-bs2.min.js"/>"></script>

<!-- page specific plugin scripts -->

<!-- ace scripts -->
<script src="<c:url value="/assets/js/ace-elements.min.js"/>"></script>
<script src="<c:url value="/assets/js/ace.min.js"/>"></script>

</html>