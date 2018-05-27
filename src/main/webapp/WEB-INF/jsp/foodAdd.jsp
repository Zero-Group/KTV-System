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
    <title>新增食物</title>
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
                                <li class="active">
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
                    <li class="active">新增食物</li>
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="widget-box">
                            <div class="widget-header widget-header-blue widget-header-flat">
                                <h4 class="lighter">新增食物</h4>
                            </div>

                            <div class="widget-body">
                                <div class="widget-main">
                                    <div class="row-fluid" id="fuelux-wizard" data-target="#step-container">
                                        <ul class="wizard-steps">
                                            <li data-target="#step1" class="active">
                                                <span class="step">1</span>
                                                <span class="title">食物名称</span>
                                            </li>

                                            <li data-target="#step2">
                                                <span class="step">2</span>
                                                <span class="title">食物价格</span>
                                            </li>

                                            <li data-target="#step3">
                                                <span class="step">3</span>
                                                <span class="title">食物数量</span>
                                            </li>

                                            <li data-target="#step4">
                                                <span class="step">4</span>
                                                <span class="title">确认信息</span>
                                            </li>
                                        </ul>
                                    </div>
                                    <hr/>
                                    <div class="step-content row-fluid position-relative" id="step-container">
                                        <form action="<c:url value="/account/food/add"/>" method="post"
                                              class="form-horizontal" id="validation-form">

                                            <div class="step-pane active" id="step1">
                                                <h3 class="lighter block blue center">输入食物名称</h3>
                                                <div class="form-group">
                                                    <div class="col-xs-12 col-sm-5"></div>
                                                    <div class="col-xs-12 col-sm-2">
                                                        <div class="clearfix">
                                                            <input type="text" name="name" id="name" class="width-100"
                                                                   title=""/>
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
                                                <h3 class="lighter block blue center">输入食物价格</h3>
                                                <div class="form-group">
                                                    <div class="col-xs-12 col-sm-5"></div>
                                                    <div class="col-xs-12 col-sm-2">
                                                        <input type="text" name="price" id="price" class="width-100"
                                                               placeholder="0 ~ 500" title=""/>
                                                    </div>
                                                    <div class="col-xs-12 col-sm-5"></div>
                                                </div>
                                            </div>

                                            <div class="step-pane" id="step3">
                                                <h3 class="lighter block blue center">输入食物数量</h3>
                                                <div class="form-group">
                                                    <div class="col-xs-12 col-sm-5"></div>
                                                    <div class="col-xs-12 col-sm-2">
                                                        <input type="text" name="number" id="number" class="width-100"
                                                               placeholder="0 ~ 1000" title=""/>
                                                    </div>
                                                    <div class="col-xs-12 col-sm-5"></div>
                                                </div>
                                            </div>

                                            <div class="step-pane" id="step4">
                                                <h3 class="blue lighter center">确认新增的食物信息</h3>
                                                <div class="col-xs-12 col-sm-5"></div>
                                                <div class="label-light clearfix col-xs-12 col-sm-2 pull-left">
                                                    <h5>名称：<span id="name2"></span></h5>
                                                    <h5>价格：<span id="price2"></span>&nbsp;元</h5>
                                                    <h5>数量：<span id="number2"></span>&nbsp;份</h5>
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
<script src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="<c:url value="/assets/js/typeahead-bs2.min.js"/>"></script>

<!-- page specific plugin scripts -->

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
            if (info.step === 3) {
                if (!$('#validation-form').valid()) return false;
            }
            document.getElementById("name2").innerHTML = $("#name").val();
            document.getElementById("price2").innerHTML = $("#price").val();
            document.getElementById("number2").innerHTML = $("#number").val();
        }).on('finished', function () {
            $("#validation-form").submit();
        }).on('stepclick', function (e) {

        });

        $('#validation-form').validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                name: 'required',
                price: {
                    required: true,
                    number: true,
                    range: [0, 500]
                },
                number: {
                    required: true,
                    digits: true,
                    range: [0, 1000]
                }
            },

            messages: {
                name: "请输入食物名称！",
                price: "请输入食物价格！(0 ~ 500)",
                number: "请输入食物数量！(0 ~ 1000)"
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