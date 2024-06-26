<%--
  Created by IntelliJ IDEA.
  User: Nada Emam
  Date: 3/21/2024
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-xl">
    <div class="container h-100">
        <a class="navbar-brand" href="Admin?controller=AdminController">
            <h1 class="tm-site-title mb-0">Product Admin</h1>
        </a>
        <button class="navbar-toggler ml-auto mr-0" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <i class="fas fa-bars tm-nav-icon"></i>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto h-100">
                <li class="nav-item">
                    <a class="${param.active == 'dashboard' ? 'active nav-link' : 'nav-link'}" href="Admin?controller=AdminController">
                        <i class="fas fa-tachometer-alt"></i>
                        Dashboard
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
<%--                <li class="nav-item dropdown">--%>

<%--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"--%>
<%--                       aria-haspopup="true" aria-expanded="false">--%>
<%--                        <i class="far fa-file-alt"></i>--%>
<%--                        <span>--%>
<%--                                    Reports <i class="fas fa-angle-down"></i>--%>
<%--                                </span>--%>
<%--                    </a>--%>
<%--                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
<%--                        <a class="dropdown-item" href="Admin?controller=AdminRefreshController">Daily Report</a>--%>
<%--                        <a class="dropdown-item" href="#">Weekly Report</a>--%>
<%--                        <a class="dropdown-item" href="#">Yearly Report</a>--%>
<%--                    </div>--%>
<%--                </li>--%>
                <li class="nav-item">
                    <a class="${param.active == 'products' ? 'active nav-link' : 'nav-link'}" href="Admin?controller=AdminProductsController">
                        <i class="fas fa-shopping-cart"></i>
                        Products
                    </a>

                </li>

                <li class="nav-item">
                    <a class="${param.active == 'accounts' ? 'active nav-link' : 'nav-link'}" href="Admin?controller=AdminAccountsController">
                        <i class="far fa-user"></i>
                        Accounts
                    </a>
                </li>
<%--                <li class="nav-item dropdown">--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"--%>
<%--                       aria-haspopup="true" aria-expanded="false">--%>
<%--                        <i class="fas fa-cog"></i>--%>
<%--                        <span>--%>
<%--                                    Settings <i class="fas fa-angle-down"></i>--%>
<%--                                </span>--%>
<%--                    </a>--%>
<%--                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
<%--                        <a class="dropdown-item" href="#">Profile</a>--%>
<%--                        <a class="dropdown-item" href="#">Billing</a>--%>
<%--                        <a class="dropdown-item" href="#">Customize</a>--%>
<%--                    </div>--%>
<%--                </li>--%>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link d-block" href="front?controller=HomeController">
                        Admin, <b>Logout</b>
                    </a>
                </li>
            </ul>
        </div>
    </div>


</nav>
