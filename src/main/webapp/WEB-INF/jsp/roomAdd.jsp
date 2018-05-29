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
    <title>新增房间</title>
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

                        <li class="active">
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
                    <li class="active">新增房间</li>
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="widget-box">
                            <div class="widget-header widget-header-blue widget-header-flat">
                                <h4 class="lighter">新增房间</h4>
                            </div>

                            <div class="widget-body">
                                <div class="widget-main">
                                    <div class="row-fluid" id="fuelux-wizard" data-target="#step-container">
                                        <ul class="wizard-steps">
                                            <li data-target="#step1" class="active">
                                                <span class="step">1</span>
                                                <span class="title">房间类型</span>
                                            </li>

                                            <li data-target="#step2">
                                                <span class="step">2</span>
                                                <span class="title">房间号码</span>
                                            </li>

                                            <li data-target="#step3">
                                                <span class="step">3</span>
                                                <span class="title">确认信息</span>
                                            </li>
                                        </ul>
                                    </div>
                                    <hr/>
                                    <div class="step-content row-fluid position-relative" id="step-container">
                                        <form action="<c:url value="/room/add"/>" method="post"
                                              class="form-horizontal" id="validation-form">

                                            <div class="step-pane active" id="step1">
                                                <h3 class="lighter block blue center">选择房间类型</h3>
                                                <div class="form-group">
                                                    <div class="col-xs-12 col-sm-5"></div>
                                                    <div class="col-xs-12 col-sm-2">
                                                        <div class="clearfix">
                                                            <select name="roomType" id="roomType" class="width-100"
                                                                    title="">
                                                                <option>L</option>
                                                                <option>M</option>
                                                                <option>S</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 col-sm-5"></div>
                                                </div>

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
                                                <div class="col-xs-12 col-sm-45"></div>
                                            </div>

                                            <div class="step-pane" id="step2">
                                                <h3 class="lighter block blue center">输入房间号码</h3>
                                                <div class="form-group">
                                                    <div class="col-xs-12 col-sm-5"></div>
                                                    <div class="col-xs-12 col-sm-2">
                                                        <input class="input-mini" name="roomNum" id="roomNum"
                                                               type="text" title="">
                                                    </div>
                                                    <div class="col-xs-12 col-sm-5"></div>
                                                </div>
                                            </div>

                                            <div class="step-pane" id="step3">
                                                <h3 class="blue lighter center">确认新增的房间信息</h3>
                                                <div class="col-xs-12 col-sm-5"></div>
                                                <div class="label-light clearfix col-xs-12 col-sm-2 pull-left">
                                                    <h5>房间编号：<span id="roomType2"></span><span id="roomNum2"></span>
                                                    </h5>
                                                </div>
                                                <div class="col-xs-12 col-sm-5"></div>
                                            </div>

                                        </form>
                                    </div>

                                    <hr/>
                                    <div class="row-fluid wizard-actions">
                                        <button class="btn btn-prev">
                                            <i class="icon-arrow-left"></i>
                                            上一步
                                        </button>

                                        <button class="btn btn-success btn-next" data-last="&nbsp;确认&nbsp;">
                                            下一步
                                            <i class="icon-arrow-right icon-on-right"></i>
                                        </button>
                                    </div>
                                </div><!-- /widget-main -->
                            </div><!-- /widget-body -->
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

<script src="<c:url value="/assets/js/fuelux/fuelux.spinner.min.js"/>"></script>
<script src="<c:url value="/assets/js/fuelux/fuelux.wizard.min.js"/>"></script>
<script src="<c:url value="/assets/js/jquery.validate.min.js"/>"></script>
<script src="<c:url value="/assets/js/additional-methods.min.js"/>"></script>

<!-- ace scripts -->
<script src="<c:url value="/assets/js/ace-elements.min.js"/>"></script>
<script src="<c:url value="/assets/js/ace.min.js"/>"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">
    jQuery(function ($) {

        $('#fuelux-wizard').ace_wizard().on('change', function (e, info) {
            if (info.step === 1) {
                if (!$('#validation-form').valid()) return false;
            }
            if (info.step === 2) {
                if (!$('#validation-form').valid()) return false;
            }
            document.getElementById("roomType2").innerHTML = $("#roomType").val();
            document.getElementById("roomNum2").innerHTML = $("#roomNum").val();
        }).on('finished', function () {
            $("#validation-form").submit();
        }).on('stepclick', function (e) {

        });

        $('#validation-form').validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                roomType: 'required',
                roomNum: {
                    required: true,
                    digits: true,
                    range: [1, 99]
                }
            },

            messages: {
                roomType: "请输入房间类型！",
                roomNum: "请输入房间号码！(1 ~ 99)"
            },

            highlight: function (e) {
                $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
            },

            success: function (e) {
                $(e).closest('.form-group').removeClass('has-error').addClass('has-info');
                $(e).remove();
            }
        });

    });

    $('#roomNum').css({
        width: 110
    }).ace_spinner({
        value: 1,
        min: 1,
        max: 99,
        step: 1,
        on_sides: true,
        icon_up: 'icon-plus smaller-75',
        icon_down: 'icon-minus smaller-75',
        btn_up_class: 'btn-success',
        btn_down_class: 'btn-danger'
    });
</script>

</html>