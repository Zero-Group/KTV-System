<%--
  Created by IntelliJ IDEA.
  User: fndnh
  Date: 2018/5/10
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>房间详情</title>
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
                    <li>
                        <a href="<c:url value="/room"/>">房间管理</a>
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
                                            <i class="icon-home"></i>
                                            房间 ${room.type}${room.id}
                                        </h3>

                                        <div class="widget-toolbar no-border invoice-info">
                                            <span class="invoice-info-label">房间状态:</span>
                                            <c:choose>
                                                <c:when test="${room.status == 1}">
                                                    <span class="label label-danger">消费</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="label label-success">空闲</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>

                                    <div class="widget-body">
                                        <div class="widget-main padding-24">
                                            <div class="row">
                                                <div class="col-xs-6">
                                                    <div class="col-xs-12 label label-lg label-info arrowed-in arrowed-right">
                                                        <b>房间信息</b>
                                                    </div>
                                                    <hr>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-xs-6 pull-left">
                                                    <i class="icon-caret-right blue"></i>
                                                    房间编号：${room.type}${room.id}
                                                    <br>
                                                    <i class="icon-caret-right blue"></i>
                                                    房间价格：${room.price}元/时
                                                </div>
                                            </div>

                                            <div class="hr hr8 hr-double hr-dotted"></div>

                                            <c:choose>
                                                <c:when test="${room.status == 1}">
                                                    <form action="<c:url value="/room/checkout"/>" method="post">
                                                        <div class="alert alert-info">
                                                            <div class="row center">
                                                                消费时间：
                                                                <i class="icon-time"></i>
                                                                <fmt:formatDate pattern="yyyy-MM-dd hh:mm"
                                                                                value="${room.startTime}"/> ~
                                                                <i class="icon-time"></i>
                                                                <fmt:formatDate pattern="yyyy-MM-dd hh:mm"
                                                                                value="${room.endTime}"/>
                                                            </div>
                                                        </div>
                                                        <div class="row center">
                                                            <input type="hidden" name="roomType" value="${room.type}"/>
                                                            <input type="hidden" name="roomNum" value="${room.id}"/>
                                                            <button class="btn btn-sm btn-info" type="submit">结束使用
                                                            </button>
                                                        </div>
                                                    </form>
                                                </c:when>
                                                <c:otherwise>
                                                    <form id="validation-form" action="<c:url value="/room/booking"/>"
                                                          method="post">
                                                        <div class="alert alert-info">
                                                            <div class="row center">
                                                                <span class="input-icon input-icon-right">
                                                                <span class="blue">消费时长：</span>
                                                                    <input type="text" id="hours" name="hours" title=""
                                                                           placeholder="订房小时数(1 ~ 10)">
                                                                    <i class="icon-time"></i>
                                                                </span>
                                                            </div>
                                                            <br>
                                                            <div class="row center">
                                                                <span class="input-icon input-icon-right">
                                                                <span class="blue">会员名字：</span>
                                                                    <input type="text" id="cname" name="cname" title=""
                                                                           placeholder="会员名字">
                                                                    <i class="icon-user"></i>
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="row center">
                                                            <input type="hidden" name="roomType" value="${room.type}"/>
                                                            <input type="hidden" name="roomNum" value="${room.id}"/>
                                                            <button class="btn btn-sm btn-info" type="submit">开始使用
                                                            </button>
                                                        </div>
                                                    </form>
                                                </c:otherwise>
                                            </c:choose>
                                            <hr>
                                            <div class="row">
                                                <div class="col-xs-12 col-sm-4"></div>
                                                <div class="col-xs-12 col-sm-4">
                                                    <c:choose>
                                                        <c:when test="${msg == null}">
                                                        </c:when>
                                                        <c:when test="${succeed == true}">
                                                            <div class="alert alert-block alert-success">
                                                                <button type="button" class="close"
                                                                        data-dismiss="alert">
                                                                    <i class="icon-remove"></i>
                                                                </button>
                                                                <p><i class="icon-ok"></i>&nbsp;&nbsp;${msg}</p>
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="alert alert-block alert-danger">
                                                                <button type="button" class="close"
                                                                        data-dismiss="alert">
                                                                    <i class="icon-remove"></i>
                                                                </button>
                                                                <p><i class="icon-bug"></i>&nbsp;&nbsp;${msg}</p>
                                                            </div>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="col-xs-12 col-sm-4"></div>
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
<script src="<c:url value="/assets/js/jquery.validate.min.js"/>"></script>

<!-- ace scripts -->
<script src="<c:url value="/assets/js/ace-elements.min.js"/>"></script>
<script src="<c:url value="/assets/js/ace.min.js"/>"></script>

<script type="text/javascript">

    jQuery(function ($) {

        $('#validation-form').validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                hours: {
                    required: true,
                    digits: true,
                    range: [1, 10]
                }
            },

            messages: {
                hours: "请输入消费时长！"
            },

            highlight: function (e) {
                $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
            },

            success: function (e) {
                $(e).closest('.form-group').removeClass('has-error').addClass('has-info');
                $(e).remove();
            }
        });
    })

</script>

</html>