<%--
  Created by IntelliJ IDEA.
  User: likejiang
  Date: 2018/6/5
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="common/tag.jsp" %>
<html lang="zh" class="no-js">
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- basic styles -->
    <link rel="stylesheet" href="<c:url value="https://cdn.bootcss.com/bootstrap/3.0.0/css/bootstrap.min.css"/>"/>

    <!--[if IE 7]>
    <link rel="stylesheet" href="/assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!-- page specific plugin styles -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/normalize.css"/>"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/assets/font/font-awesome-4.2.0/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/demo.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/checkout-cornerflat.css"/>"/>

    <!-- fonts -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="<c:url value="/assets/css/ace.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/assets/css/ace-rtl.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/assets/css/ace-skins.min.css"/>"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="/assets/css/ace-ie.min.css"/>
    <![endif]-->

    <!-- ace settings handler -->
    <script src="<c:url value="/assets/js/ace-extra.min.js"/>"></script>

    <!--[if lt IE 9]>
    <script src="/assets/js/html5shiv.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>消费页面</title>

</head>
<body>
<div class="main-container">

    <div class="navbar navbar-fixed-bottom">
        <div class="space-2"></div>
        <form action="<c:url value="/consume/renew"/>" id="validation-form" method="post">
            <div class="col-xs-6"></div>
            <div class="col-xs-3">
                <c:choose>
                    <c:when test="${msg == null}">
                    </c:when>
                    <c:when test="${succeed == true}">
                        <h4><i class="icon-ok"></i>&nbsp;&nbsp;${msg}</h4>
                    </c:when>
                    <c:otherwise>
                        <h4><i class="icon-bug"></i>&nbsp;&nbsp;${msg}</h4>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="input-group pull-right col-xs-3">
                <input type="hidden" name="oid" value="${oid}">
                <input class="form-control" type="text" id="hours" name="hours" title=""
                       placeholder="续订时长(1 ~ 5)">
                <span class="input-group-btn">
                    <button class="btn btn-sm btn-danger" type="submit">续订房间</button>
                </span>
            </div>
        </form>

    </div>
    <c:forEach var="i" begin="1" end="${rows}">
        <div class="row">
            <c:forEach items="${allfood}" var="food" begin="${6*(i-1)}" end="${6*(i-1)+5}">
                <div class="col-xs-12 col-sm-2 widget-container-span ui-sortable">
                    <div class="widget-box" style="opacity: 1;">
                        <div class="widget-header">
                            <h4 class="grey">${food.fname}</h4>

                            <div class="widget-toolbar">
                                <span class="label label-info">${food.stock}份</span>
                            </div>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main padding-2">
                                <div class="alert alert-info">价格：<br>
                                        ${food.price}元/份
                                    <div class="space-8"></div>
                                    <div class="center foodDetail">
                                        <input type="hidden" class="foodName" value="${food.fname}">
                                        <input type="hidden" class="unitPrice" value="${food.price}">
                                        <input class="input-mini foodNum" name="foodNum"
                                               type="text" title="">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <br>
    </c:forEach>
    <section class="content">
        <div class="checkout">
            <a class="checkout__button" href="#"><!-- Fallback location -->
                <span class="checkout__text">
                    <svg class="checkout__icon" width="36px" height="36px">
                        <path fill="#fff" d="M33.623,
							8.004c-0.185-0.268-0.486-0.434-0.812-0.447L12.573,
							6.685c-0.581-0.025-1.066,0.423-1.091,1.001 c-0.025,
							0.578,0.423,1.065,1.001,1.091L31.35,9.589l-3.709,
							11.575H11.131L8.149,4.924c-0.065-0.355-0.31-0.652-0.646-0.785 L2.618,
							2.22C2.079,2.01,1.472,2.274,1.26,2.812s0.053,1.146 0.591,1.357l4.343,
							1.706L9.23,22.4c0.092,0.497,0.524,0.857,1.03,0.857 h0.504l-1.15,
							3.193c-0.096,0.268-0.057,0.565,0.108,0.798c0.163,0.232,0.429,0.37,
							0.713,0.37h0.807 c-0.5,0.556-0.807,1.288-0.807,2.093c0,1.732,1.409,
							3.141,3.14,3.141c1.732,0,3.141-1.408,
							3.141-3.141c0-0.805-0.307-1.537-0.807-2.093h6.847c-0.5,0.556-0.806,
							1.288-0.806,2.093c0,1.732,1.407,3.141,3.14,3.141 c1.731,0,3.14-1.408,
							3.14-3.141c0-0.805-0.307-1.537-0.806-2.093h0.98c0.482,0,0.872-0.391,
							0.872-0.872s-0.39-0.873-0.872-0.873 H11.675l0.942-2.617h15.786c0.455,
							0,0.857-0.294,0.996-0.727l4.362-13.608C33.862,8.612,33.811,8.272,
							33.623,8.004z M13.574,31.108c-0.769,0-1.395-0.626-1.395-1.396s0.626-1.396,
							1.395-1.396c0.77,0,1.396,0.626,1.396,1.396S14.344,31.108,13.574,
							31.108z M25.089,31.108c-0.771,0-1.396 0.626-1.396-1.396s0.626-1.396,
							1.396-1.396c0.77,0,1.396,0.626,1.396,1.396 S25.858,31.108,25.089,31.108z">
                        </path>
                    </svg>
                </span>
            </a>
            <div class="checkout__order">
                <div class="checkout__order-inner">
                    <table class="checkout__summary" id="checktable">
                        <thead>
                        <tr>
                            <th>食物</th>
                            <th>单价</th>
                            <th>数量</th>
                            <th>总价</th>
                        </tr>
                        </thead>
                        <tbody></tbody>
                        <tfoot>
                        <tr>
                            <th colspan="4">总价 <span class="checkout__total" id="total">0</span>元</th>
                        </tr>
                        </tfoot>
                    </table><!-- /checkout__summary -->
                    <button class="checkout__option checkout__option--silent checkout__cancel">
                        <i class="fa fa-angle-left"></i> 返回
                    </button>
                    <button class="checkout__option" id="buy">购买</button>
                    <button class="checkout__close checkout__cancel">
                        <i class="icon fa fa-fw fa-close"></i>
                    </button>
                </div><!-- /checkout__order-inner -->
            </div><!-- /checkout__order -->
        </div><!-- /checkout -->
    </section>

</div><!-- /container -->

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
<script src="<c:url value="/assets/js/classie.js"/>"></script>

<!-- ace scripts -->
<script src="<c:url value="/assets/js/ace-elements.min.js"/>"></script>
<script src="<c:url value="/assets/js/ace.min.js"/>"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">

    jQuery(function ($) {
        $('.foodNum').ace_spinner({
            value: 0,
            min: 0,
            max: 20,
            step: 1,
            on_sides: true,
            icon_up: 'fa fa-plus smaller-75',
            icon_down: 'fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });

        $('#validation-form').validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                hours: {
                    required: true,
                    digits: true,
                    range: [1, 5]
                }
            },

            messages: {
                hours: "请输入续费时长！"
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

    (function () {
        [].slice.call(document.querySelectorAll('.checkout')).forEach(function (el) {
            var openCtrl = el.querySelector('.checkout__button'),
                closeCtrls = el.querySelectorAll('.checkout__cancel');

            openCtrl.addEventListener('click', function (ev) {
                ev.preventDefault();
                classie.add(el, 'checkout--active');
            });

            [].slice.call(closeCtrls).forEach(function (ctrl) {
                ctrl.addEventListener('click', function () {
                    classie.remove(el, 'checkout--active');
                });
            });
        });
    })();

    $(function () {
        $(".btn").click(function () {
            updateTable();
        });

        $("#buy").click(function () {
            var jsonStr = tableToJson("checktable");
            var oid = ${oid};
            var total = document.getElementById("total").innerHTML;
            $.ajax({
                url: "/consume/placeorder",
                type: 'POST',
                data: {
                    jsonStr: jsonStr,
                    oid: oid,
                    total: total
                },
                dataType: 'html',
                success: function () {
                    alert("下单成功！");
                },
                Error: function () {
                    alert("下单失败！");
                }
            });
        });
    });

    function updateTable() {
        $("#checktable tbody").empty();
        var foods = document.getElementsByClassName("foodDetail");
        var total = 0;
        $(foods).each(function (i, obj) {
            var foodName = $(this).children(".foodName").val();
            var unitPrice = $(this).children(".unitPrice").val();
            var list = document.getElementsByClassName("foodNum");
            var number = list[i].value;
            if (number !== "0") {
                $("#checktable tbody").append('<tr>' +
                    '<td>' + foodName + '</td>' +
                    '<td>' + unitPrice + '</td>' +
                    '<td>' + number + '</td>' +
                    '<td>' + unitPrice * number + '</td></tr>');
                total += unitPrice * number;
            }
        });
        $("#total").text(total);
    }

    var keysArr = ["name", "unitPrice", "number", "totalPrice"];

    /**
     * 获取表格中的数据并转换为JSON数据
     *
     * @return {string}
     */
    function tableToJson(tableid) {
        var rows = document.getElementById(tableid).rows.length;
        var colums = document.getElementById(tableid).rows[0].cells.length;
        var json = "[";
        var tdValue;
        for (var i = 1; i < rows - 1; i++) {
            json += "{";
            for (var j = 0; j < colums; j++) {
                tdName = keysArr[j];
                json += "\"";
                json += tdName;
                json += "\"";
                json += ":";
                tdValue = document.getElementById(tableid).rows[i].cells[j].innerHTML;
                json += "\"";
                json += tdValue;
                json += "\"";
                json += ",";
            }
            json = json.substring(0, json.length - 1);
            json += "}";
            json += ",";
        }
        json = json.substring(0, json.length - 1);
        json += "]";
        return json;
    }

</script>

</body>
</html>
