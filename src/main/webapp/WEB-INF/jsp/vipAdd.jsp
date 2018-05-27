<%--
  Created by IntelliJ IDEA.
  User: lixinheng
  Date: 2018/5/14
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>新增会员</title>
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

                <li class="active">
                    <a href="<c:url value="/vip"/>" class="dropdown-toggle">
                        <i class="icon-user"></i>
                        <span class="menu-text">会员管理</span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="<c:url value="/vip/all"/>">
                                <i class="icon-list-ul"></i>
                                所有会员
                            </a>
                        </li>

                        <li>
                            <a href="<c:url value="/vip/query"/>">
                                <i class="icon-search"></i>
                                查询会员
                            </a>
                        </li>

                        <li class="active">
                            <a href="<c:url value="/vip/add"/>">
                                <i class="icon-plus"></i>
                                新增会员
                            </a>
                        </li>
                    </ul>
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
                        <a href="<c:url value="/vip"/>">会员管理</a>
                    </li>
                    <li class="active">会员房间</li>
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="widget-box">
                            <div class="widget-header widget-header-blue widget-header-flat">
                                <h4 class="lighter">新增会员</h4>
                            </div>

                            <div class="widget-body">
                                <div class="widget-main">
                                    <div class="row-fluid" id="fuelux-wizard" data-target="#step-container">
                                        <ul class="wizard-steps">
                                            <li data-target="#step1" class="active">
                                                <span class="step">1</span>
                                                <span class="title">会员名字</span>
                                            </li>

                                            <li data-target="#step2">
                                                <span class="step">2</span>
                                                <span class="title">会员电话</span>
                                            </li>

                                            <li data-target="#step3">
                                                <span class="step">3</span>
                                                <span class="title">确认信息</span>
                                            </li>
                                        </ul>
                                    </div>
                                    <hr/>
                                    <div class="step-content row-fluid position-relative" id="step-container">
                                        <form action="<c:url value="/vip/add"/>" method="post"
                                              class="form-horizontal" id="validation-form">

                                            <div class="step-pane active" id="step1">
                                                <h3 class="lighter block blue center">输入会员名字</h3>
                                                <div class="form-group">
                                                    <div class="col-xs-12 col-sm-5"></div>
                                                    <div class="col-xs-12 col-sm-2">
                                                        <div class="clearfix">
                                                            <input type="text" name="cname" id="cname" class="width-100"
                                                                   placeholder="输入4 ~ 12个字符" title=""/>
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
                                                <div class="col-xs-12 col-sm-4"></div>
                                            </div>

                                            <div class="step-pane" id="step2">
                                                <h3 class="lighter block blue center">输入电话号码</h3>
                                                <div class="form-group">
                                                    <div class="col-xs-12 col-sm-5"></div>
                                                    <div class="col-xs-12 col-sm-2">
                                                        <div class="clearfix">
                                                            <input type="text" name="phone" id="phone" class="width-100"
                                                                   title=""/>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 col-sm-5"></div>
                                                </div>
                                            </div>

                                            <div class="step-pane" id="step3">
                                                <h3 class="blue lighter center">确认新增的会员信息</h3>
                                                <div class="col-xs-12 col-sm-5"></div>
                                                <div class="label-light clearfix col-xs-12 col-sm-2 pull-left">
                                                    <h5>
                                                        名字：<span id="cname2"></span>
                                                    </h5>
                                                    <h5>
                                                        电话：<span id="phone2"></span>
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
<script src="<c:url value="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"/>"></script>
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
            document.getElementById("cname2").innerHTML = $("#cname").val();
            document.getElementById("phone2").innerHTML = $("#phone").val();
        }).on('finished', function () {
            $("#validation-form").submit();
        }).on('stepclick', function (e) {

        });

        $.validator.addMethod("mobile", function (value, element) {
            var length = value.length;
            var mobile = /^(((13[0-9])|(15[0-9]))+\d{8})$/;
            return this.optional(element) || (length === 11 && mobile.test(value));
        }, "电话号码格式错误！");

        $('#validation-form').validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                cname: {
                    required: true,
                    rangelength: [4, 12]
                },
                phone: {
                    required: true,
                    mobile: true
                }
            },

            messages: {
                cname: "请输入会员名字！",
                phone: "电话号码格式错误！"
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
</script>

</html>