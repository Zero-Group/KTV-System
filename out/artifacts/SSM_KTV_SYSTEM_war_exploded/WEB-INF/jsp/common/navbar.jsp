<%@ page contentType="text/html;charset=UTF-8" %>

<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("/login");
    }
%>

<div class="navbar navbar-default" id="navbar">
    <div class="navbar-container grey" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="<c:url value="/ktv"/>" class="navbar-brand">
                <i class="icon-leaf"></i>
                <span class="red">KTV</span>
                <span class="white">管理系统</span>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->
        <div class="navbar-header pull-right nav-pills">
            <a href="<c:url value="/logout"/>" class="navbar-brand">
                <h5>
                    <i class="icon-off"></i>
                    退出登录
                </h5>
            </a>
        </div>
    </div><!-- /.container -->
</div>