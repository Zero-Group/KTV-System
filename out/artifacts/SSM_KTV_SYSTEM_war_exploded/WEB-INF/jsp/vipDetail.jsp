<%--
  Created by IntelliJ IDEA.
  User: fndnh
  Date: 2018/5/10
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>会员详情</title>
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

                        <li>
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
                    <li class="active">${title}</li>
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="row">
                            <div class="col-xs-12 center">
                                <div class="well-lg blue">
                                    <h1>会员详情</h1>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-4"></div>
                            <div class="col-xs-12 col-sm-4">
                                <form id="form1" action="<c:url value="/vip/delete"/>" method="post">
                                    <table class="table table-bordered table-hover">
                                        <tbody>
                                        <tr>
                                            <td>会员姓名</td>
                                            <td>${vip.cname}</td>
                                            <td class="center">
                                                <a href="#modal-wizard" data-toggle="modal">
                                                    <button class="btn btn-xs btn-primary">修改名字</button>
                                                </a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>电话号码</td>
                                            <td colspan="2">${vip.phone}</td>
                                        </tr>
                                        <tr class="center">
                                            <td colspan="3">
                                                <input type="hidden" name="cname" value="${vip.cname}">
                                                <button id="del" type="button" class="btn btn-xs btn-danger">删除会员
                                                </button>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </form>
                            </div>
                            <div class="col-xs-12 col-sm-4"></div>
                        </div>
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

                        <div id="modal-wizard" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-body row-fluid" id="fuelux-wizard"
                                         data-target="#modal-step-contents">
                                        <ul class="wizard-steps">
                                            <li data-target="#modal-step1" class="active">
                                                <span class="step">1</span>
                                                <span class="title">输入新名字</span>
                                            </li>

                                            <li data-target="#modal-step2">
                                                <span class="step">2</span>
                                                <span class="title">确认修改</span>
                                            </li>
                                        </ul>
                                    </div>
                                    <hr>
                                    <div class="row-fluid step-content" id="modal-step-contents">
                                        <form action="<c:url value="/vip/changename"/>" method="post"
                                              class="form-horizontal" id="validation-form">
                                            <div class="step-pane active" id="modal-step1">
                                                <h3 class="lighter block blue center">输入新的会员名字</h3>
                                                <div class="form-group">
                                                    <div class="col-xs-12 col-sm-4"></div>
                                                    <div class="col-xs-12 col-sm-4">
                                                        <div class="clearfix">
                                                            <input type="hidden" name="id" value="${vip.id}"/>
                                                            <input type="text" name="newname" id="newname"
                                                                   class="width-100"
                                                                   placeholder="输入2 ~ 12个字符" title=""/>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 col-sm-4"></div>
                                                </div>
                                            </div>

                                            <div class="step-pane" id="modal-step2">
                                                <h3 class="blue lighter center">确认新的会员名字</h3>
                                                <div class="col-xs-12 col-sm-4"></div>
                                                <div class="label-light clearfix col-xs-12 col-sm-4 pull-left">
                                                    <h5>
                                                        新名字：<span id="newname2"></span>
                                                    </h5>
                                                </div>
                                                <div class="col-xs-12 col-sm-4"></div>
                                            </div>
                                        </form>
                                    </div>
                                    <hr>
                                    <div class="modal-body row-fluid wizard-actions">
                                        <button class="btn btn-sm btn-prev">
                                            <i class="icon-arrow-left"></i>
                                            上一步
                                        </button>

                                        <button class="btn btn-success btn-sm btn-next" data-last="确定">
                                            下一步
                                            <i class="icon-arrow-right icon-on-right"></i>
                                        </button>

                                        <button class="btn btn-danger btn-sm pull-left" data-dismiss="modal">
                                            <i class="icon-remove"></i>
                                            取消
                                        </button>
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
<script src="<c:url value="/assets/js/fuelux/fuelux.wizard.min.js"/>"></script>
<script src="<c:url value="/assets/js/jquery.validate.min.js"/>"></script>
<script src="<c:url value="/assets/js/additional-methods.min.js"/>"></script>
<script src="<c:url value="/assets/js/bootbox.min.js"/>"></script>

<!-- ace scripts -->
<script src="<c:url value="/assets/js/ace-elements.min.js"/>"></script>
<script src="<c:url value="/assets/js/ace.min.js"/>"></script>

<script type="text/javascript">

    $(function () {
        $("#del").on("click", function () {
            bootbox.confirm({
                size: "small",
                message: "<h4>确认删除会员${vip.cname}吗?</h4>",
                buttons: {
                    confirm: {
                        label: '确定',
                        className: 'btn-sm btn-success'
                    },
                    cancel: {
                        label: '取消',
                        className: 'btn-sm btn-danger'
                    }
                },
                /* result is a boolean; true = OK, false = Cancel*/
                callback: function (result) {
                    if (result) {
                        $("#form1").submit();
                    }
                }
            });
        });
    });

    jQuery(function ($) {
        $('#fuelux-wizard').ace_wizard().on('change', function (e, info) {
            if (info.step === 1) {
                if (!$('#validation-form').valid()) return false;
            }

            document.getElementById("newname2").innerHTML = $("#newname").val();
        }).on('finished', function () {
            $("#validation-form").submit();
        }).on('stepclick', function (e) {

        });

        $('#validation-form').validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                newname: {
                    required: true,
                    rangelength: [2, 12]
                }
            },

            messages: {
                newname: "请输入新的会员名字！"
            },

            highlight: function (e) {
                $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
            },

            success: function (e) {
                $(e).closest('.form-group').removeClass('has-error').addClass('has-info');
                $(e).remove();
            }
        });

        $('#modal-wizard .modal-header').ace_wizard();
        $('#modal-wizard .wizard-actions .btn[data-dismiss=modal]').removeAttr('disabled');
    })

</script>

</html>