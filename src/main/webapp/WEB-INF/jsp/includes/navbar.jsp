<nav class="navbar navbar-inverse mainNav">
    <div class="container-fluid">
        <div class="navbar-header navHeader">
                <%--HOME--%>
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
                <a class="navbar-brand" href="/">
                    <img class="logo" src="/static/images/header-logo.png" alt="Brand"/>
                </a>
        </div>
        <div id="navbar-collapse-1" class="collapse navbar-collapse">
            <ul class="nav navbar-nav mainNavList">
                <%--PAGE LINKS--%>
                <li><a href="/employee"><i class="fa fa-user"></i> Employee</a></li>
                <li><a href="/project"><i class="fa fa-file"></i> Project</a></li>
                <li><a href="/contact"><i class="fa fa-comments"></i> Contact</a></li>
                <li><a href="/admin"><i class="fa fa-gear"></i> Admin</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%--LOGIN LINK--%>
                <li><a class="btn btn-default login" href="#"><i class="fa fa-lock"></i> Login</a></li>
            </ul>
        </div>
    </div>
</nav>
