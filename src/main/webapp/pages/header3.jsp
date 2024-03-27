<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page session="false" %>--%>
<header class="header-v3">
  <!-- Header desktop -->
  <div class="container-menu-desktop trans-03">
    <div class="wrap-menu-desktop">
      <nav class="limiter-menu-desktop p-l-45">
        <!-- Logo desktop -->
        <a href="#" class="logo">
          <img src="assets/images/icons/ddee.png" alt="IMG-LOGO" />
        </a>

        <!-- Menu desktop -->
        <div class="menu-desktop">
          <ul class="main-menu">
            <li class="${param.active == 'home' ? 'active-menu' : ''}">
              <a href="front?controller=HomeController">Home</a>
            </li>

            <li class="${param.active == 'shop' ? 'active-menu' : ''}">
              <a href="front?controller=FetchProducts">Shop</a>
            </li>

            <li class="${param.active == 'features' ? 'active-menu' : ''}">
              <a href="front?controller=FetchProducts">Features</a>
            </li>

            <li class="${param.active == 'blog' ? 'active-menu' : ''}">
              <a href="front?controller=BlogController">Blog</a>
            </li>

            <li class="${param.active == 'about' ? 'active-menu' : ''}">
              <a href="front?controller=AboutController">About</a>
            </li>

            <li class="${param.active == 'contact' ? 'active-menu' : ''}">
              <a href="front?controller=ContactController">Contact</a>
            </li>

            <%--            <li class="${param.active == 'admin' ? 'active-menu' : ''}">--%>
            <%--              <a href="front?controller=AdminController">Admin</a>--%>
            <%--            </li>--%>
          </ul>
        </div>

        <!-- Icon header -->
        <div class="wrap-icon-header flex-w flex-r-m h-full">
          <div class="flex-c-m h-full p-r-25 bor6">
<c:if test="${empty sessionScope.currentUser}">
            <a
                    class="flex-c-m h-full p-r-25 bor6 custom-style"
                    href="front?controller=LoginController"
            >LOGIN</a>
</c:if>

            <div
                    class="icon-header-item cl0 hov-cl1 trans-04 p-lr-11 icon-header-noti js-show-cart cart-count"
                    data-notify="2"
            >
              <i class="zmdi zmdi-shopping-cart"></i>
            </div>
          </div>

          <!-- <div class="flex-c-m h-full p-lr-19">
            <div
              class="icon-header-item cl0 hov-cl1 trans-04 p-lr-11 js-show-sidebar"
            >
              <i class="zmdi zmdi-menu"></i>
            </div>
          </div> -->
        </div>
      </nav>
    </div>
  </div>

  <!-- Header Mobile -->
  <div class="wrap-header-mobile">
    <!-- Logo moblie -->
    <div class="logo-mobile">
      <a href="front?controller=HomeController"
      ><img src="assets/images/icons/dd.png" alt="IMG-LOGO"
      /></a>
    </div>

    <!-- Icon header -->
    <div class="wrap-icon-header flex-w flex-r-m h-full m-r-15">
      <div class="flex-c-m h-full p-r-5">
        <div
                class="icon-header-item cl2 hov-cl1 trans-04 p-lr-11 icon-header-noti js-show-cart"
                data-notify="2"
        >
          <i class="zmdi zmdi-shopping-cart"></i>
        </div>
      </div>
    </div>

    <!-- Button show menu -->
    <div class="btn-show-menu-mobile hamburger hamburger--squeeze">
      <span class="hamburger-box">
        <span class="hamburger-inner"></span>
      </span>
    </div>
  </div>

  <!-- Menu Mobile -->
  <div class="menu-mobile">
    <ul class="main-menu-m">

      <li>
        <a href="front?controller=LoginController">Login</a>
      </li>

      <li>
        <a href="front?controller=HomeController">Home</a>
        <!-- <ul class="sub-menu-m">
          <li><a href="index.html">Homepage 1</a></li>
        </ul> -->
        <span class="arrow-main-menu-m">
          <i class="fa fa-angle-right" aria-hidden="true"></i>
        </span>
      </li>

      <li>
        <a
                href="front?controller=FetchProducts"
                class="label1 rs1"
                data-label1="hot"
        >
          Shop</a
        >
      </li>


      <li>
        <a href="front?controller=BlogController">Blog</a>
      </li>

      <li>
        <a href="front?controller=AboutController">About</a>
      </li>

      <li>
        <a href="front?controller=ContactController">Contact</a>
      </li>
    </ul>
  </div>

  <!-- Modal Search -->
  <div class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
    <button class="flex-c-m btn-hide-modal-search trans-04">
      <i class="zmdi zmdi-close"></i>
    </button>

    <form class="container-search-header">
      <div class="wrap-search-header">
        <input class="plh0" type="text" name="search" placeholder="Search..." />

        <button class="flex-c-m trans-04">
          <i class="zmdi zmdi-search"></i>
        </button>
      </div>
    </form>
  </div>
</header>
<script defer src="assets/customJS/cartProducts.js"></script>
<script defer src="assets/customJS/header.js"></script>