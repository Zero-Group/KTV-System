<%--
  Created by IntelliJ IDEA.
  User: fndnh
  Date: 2018/5/10
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>账目管理</title>
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
                        <li>
                            <a href="<c:url value="/account/food"/>">
                                <i class="icon-food"></i>
                                食物管理
                                <b class="arrow icon-angle-down"></b>
                            </a>
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
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="page-content">
                            <div class="row">
                                <div class="col-xs-12">
                                    <!-- PAGE CONTENT BEGINS -->
                                    <h1>
                                        账目管理系统
                                    </h1>
                                    <div class="row">
                                        <div class="col-xs-6 col-sm-3 pricing-box">
                                            <div class="widget-box">
                                                <div class="widget-header header-color-dark">
                                                    <h5 class="bigger lighter">食物管理</h5>
                                                </div>

                                                <div class="widget-body">
                                                    <div class="widget-main">
                                                        <ul class="list-unstyled spaced2">
                                                            <li>
                                                                <i class="icon-ok green"></i>
                                                                包含食物名称，数量，以及剩余状况
                                                            </li>

                                                            <li>
                                                                <i class="icon-ok green"></i>
                                                                进货时，请及时通过本系统增加货物
                                                            </li>

                                                            <li>
                                                                <i class="icon-ok green"></i>
                                                                提供有查询功能
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-xs-6 col-sm-3 pricing-box">
                                            <div class="widget-box">
                                                <div class="widget-header header-color-orange">
                                                    <h5 class="bigger lighter">订单管理</h5>
                                                </div>

                                                <div class="widget-body">
                                                    <div class="widget-main">
                                                        <ul class="list-unstyled spaced2">
                                                            <li>
                                                                <i class="icon-ok green"></i>
                                                                提供账单列表和指定查询功能
                                                            </li>

                                                            <li>
                                                                <i class="icon-ok green"></i>
                                                                账单由系统生成，无需手动修改
                                                            </li>

                                                            <li>
                                                                <i class="icon-ok green"></i>
                                                                所有账单都将被自动保存
                                                            </li>

                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-sm-5" style="float:right;">
                                            <canvas id="canvas" width="500" height="500"></canvas>
                                            <script src="<c:url value="/assets/js/clock2.js"/>"></script>
                                        </div>
                                    </div>
                                    <!-- PAGE CONTENT ENDS -->
                                </div><!-- /.col -->
                            </div><!-- /.row -->
                        </div><!-- /.page-content -->

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
