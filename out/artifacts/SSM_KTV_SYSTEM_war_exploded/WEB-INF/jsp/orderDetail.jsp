<%--
  Created by IntelliJ IDEA.
  User: lixinheng
  Date: 2018/5/14
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>订单详情</title>
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

                        <li class="active">
                            <a href="<c:url value="/account/order"/>" class="dropdown-toggle">
                                <i class="icon-money"></i>
                                订单管理
                                <b class="arrow icon-angle-down"></b>
                            </a>

                            <ul class="submenu">
                                <li>
                                    <a href="<c:url value="/account/order/all"/>">
                                        <i class="icon-list-ul"></i>
                                        所有订单
                                    </a>
                                </li>

                                <li>
                                    <a href="<c:url value="/account/order/query"/>">
                                        <i class="icon-search"></i>
                                        查询订单
                                    </a>
                                </li>
                            </ul>
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
                        <a href="<c:url value="/account/order"/>">订单管理</a>
                    </li>
                    <li class="active">${title}</li>
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="row">
                            <div class="col-sm-10 col-sm-offset-1">
                                <div class="widget-box transparent invoice-box">
                                    <div class="widget-header widget-header-large">
                                        <h3 class="grey lighter pull-left position-relative">
                                            <i class="icon-leaf green"></i>
                                            订单详情
                                        </h3>

                                        <div class="widget-toolbar no-border invoice-info">
                                            <span class="invoice-info-label">订单编号:</span>
                                            <span class="red">${order.id}</span>
                                        </div>
                                    </div>

                                    <div class="widget-body">
                                        <div class="widget-main padding-24">
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <div class="row">
                                                        <div class="col-xs-11 label label-lg label-info arrowed-in arrowed-right">
                                                            <b>房间信息</b>
                                                        </div>
                                                    </div>

                                                    <div class="row">
                                                        <ul class="list-unstyled spaced">
                                                            <li>
                                                                <i class="icon-caret-right blue"></i>
                                                                房间编号：${order.room}
                                                            </li>
                                                            <li>
                                                                <i class="icon-caret-right blue"></i>
                                                                房间价格：${list.get(0).unitPrice}元/时
                                                            </li>
                                                            <li>
                                                                <i class="icon-caret-right blue"></i>
                                                                消费时长：${list.get(0).number}小时
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div><!-- /span -->

                                                <div class="col-sm-6">
                                                    <div class="row">
                                                        <div class="col-xs-11 label label-lg label-success arrowed-in arrowed-right">
                                                            <b>顾客信息</b>
                                                        </div>
                                                    </div>

                                                    <div>
                                                        <ul class="list-unstyled  spaced">
                                                            <li>
                                                                <i class="icon-caret-right green"></i>
                                                                会员姓名：${order.cname}
                                                            </li>
                                                            <li>
                                                                <i class="icon-caret-right green"></i>
                                                                会员电话：${order.phone}
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div><!-- /span -->
                                            </div><!-- row -->

                                            <div>
                                                <table class="table table-striped table-bordered">
                                                    <thead>
                                                    <tr>
                                                        <th>条目</th>
                                                        <th>单价</th>
                                                        <th>数量</th>
                                                        <th>总价</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${list}" var="detail">
                                                        <tr>
                                                            <td>${detail.name}</td>
                                                            <td>${detail.unitPrice}</td>
                                                            <td>${detail.number}</td>
                                                            <td>${detail.totalPrice}</td>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>

                                            <div class="hr hr8 hr-double hr-dotted"></div>

                                            <div class="row">
                                                <div class="col-sm-5 pull-right">
                                                    <h4 class="pull-right">
                                                        总消费金额：
                                                        <span class="red">${order.price}元</span>
                                                    </h4>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
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