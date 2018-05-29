<%--
  Created by IntelliJ IDEA.
  User: fndnh
  Date: 2018/5/10
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>房间管理</title>
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

                        <li>
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
                    <li class="active">房间管理</li>
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="col-sm-6">
                            <h1>房间价目与基础服务</h1>
                            <div class="row">
                                <div class="col-sm-4 pricing-box">
                                    <div class="widget-box">
                                        <div class="widget-header header-color-dark">
                                            <h5 class="bigger lighter">Small room</h5>
                                        </div>

                                        <div class="widget-body">
                                            <div class="widget-main">
                                                <ul class="list-unstyled spaced2">
                                                    <li>
                                                        <i class="icon-ok green"></i>
                                                        适合3-4人使用（不得超过五人）
                                                    </li>

                                                    <li>
                                                        <i class="icon-ok green"></i>
                                                        不含饮料小吃
                                                    </li>

                                                    <li>
                                                        <i class="icon-ok green"></i>
                                                        节假日加收20%服务费
                                                    </li>

                                                    <li>
                                                        <i class="icon-ok green"></i>
                                                        连续订5小时后，第六小时起按半价
                                                    </li>
                                                </ul>

                                                <hr>
                                                <div class="price">
                                                    计时收费：¥80
                                                    <small>/hour</small>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-sm-4 pricing-box">
                                    <div class="widget-box">
                                        <div class="widget-header header-color-orange">
                                            <h5 class="bigger lighter">Middle Room</h5>
                                        </div>

                                        <div class="widget-body">
                                            <div class="widget-main">
                                                <ul class="list-unstyled spaced2">
                                                    <li>
                                                        <i class="icon-ok green"></i>
                                                        适合6-20人使用（不得超过12人）
                                                    </li>

                                                    <li>
                                                        <i class="icon-ok green"></i>
                                                        随机附赠饮料半打,小吃5份
                                                    </li>

                                                    <li>
                                                        <i class="icon-ok green"></i>
                                                        节假日加收20%服务费
                                                    </li>

                                                    <li>
                                                        <i class="icon-ok green"></i>
                                                        连续订5小时后，第六小时起按半价收费
                                                    </li>
                                                </ul>

                                                <hr>
                                                <div class="price">
                                                    计时收费：¥130
                                                    <small>/hour</small>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-sm-4 pricing-box">
                                    <div class="widget-box">
                                        <div class="widget-header header-color-blue">
                                            <h5 class="bigger lighter">Large Room</h5>
                                        </div>

                                        <div class="widget-body">
                                            <div class="widget-main">
                                                <ul class="list-unstyled spaced2">
                                                    <li>
                                                        <i class="icon-ok green"></i>
                                                        适合20人以上使用（不得超过30人）
                                                    </li>

                                                    <li>
                                                        <i class="icon-ok green"></i>
                                                        附赠啤酒一箱，小吃8份
                                                    </li>

                                                    <li>
                                                        <i class="icon-ok green"></i>
                                                        节假日加收20%服务费
                                                    </li>

                                                    <li>
                                                        <i class="icon-ok green"></i>
                                                        连续订5小时后，第六小时起按半价收费
                                                    </li>
                                                </ul>

                                                <hr>
                                                <div class="price">
                                                    计时收费：¥200
                                                    <small>/hour</small>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="col-sm-6">
                            <canvas id="canvas" width="500" height="500"></canvas>
                            <script src="<c:url value="/assets/js/clock.js"/>"></script>
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
