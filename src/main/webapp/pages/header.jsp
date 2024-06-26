<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="header-v4">
  <!-- Header desktop -->
  <div class="container-menu-desktop">
    <!-- Topbar -->
    <div class="top-bar">
      <div class="content-topbar flex-sb-m h-full container">
        <div class="left-top-bar">
          Free shipping for standard order over $100
        </div>

        <div class="right-top-bar flex-w h-full">
          <a href="#" class="flex-c-m trans-04 p-lr-25"> Help & FAQs </a>

          <c:choose>
            <c:when test="${not empty sessionScope.currentUser}">
              <a

                      href="front?controller=MyAccountController"
                      class="flex-c-m trans-04 p-lr-25"
              >
                My Account
              </a>
            </c:when>
            <c:otherwise>
              <a

                      href="front?controller=RegisterController"
                      class="flex-c-m trans-04 p-lr-25"
              >
                Register
              </a>
            </c:otherwise>
          </c:choose>
    <c:if test="${not empty sessionScope.currentUser}">
          <a href="front?controller=LogOutController" class="flex-c-m trans-04 p-lr-25"> Logout </a>
    </c:if>

        </div>
      </div>
    </div>

    <div class="wrap-menu-desktop how-shadow1">
      <nav class="limiter-menu-desktop container">
        <!-- Logo desktop -->
        <a href="#" class="logo">
          <img src="assets/images/icons/dd.png" alt="IMG-LOGO" />
        </a>

        <!-- Menu desktop -->
        <div class="menu-desktop">
          <ul class="main-menu">
            <!-- <li>
              <a href="../index.jsp">Home</a>
              <ul class="sub-menu">
                <li><a href="../index.html">Homepage 1</a></li>
                <li><a href="home-02.html">Homepage 2</a></li>
                <li><a href="home-03.html">Homepage 3</a></li>
              </ul>
            </li> -->

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
        <div class="wrap-icon-header flex-w flex-r-m">
          <div
                  class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11"
          >
            <i class="zmdi zmdi-search"></i>
          </div>

          <div
                  class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart cart-count"
                  data-notify="2"
          >
            <i class="zmdi zmdi-shopping-cart"></i>
          </div>
<%--          <c:if test="${not empty sessionScope.currentUser}">--%>
<%--            <p id = "logOut" style="cursor: pointer;" href=""class="flex-c-m trans-04 p-lr-25"  onClick="removeCookieAndReload();"><i style="color: red;font-size:24px;" class="fa fa-sign-out" ></i></p>--%>
<%--          </c:if>--%>
          <!-- <a
            href="#"
            class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti"
            data-notify="0"
          > -->
          <!-- <i class="zmdi zmdi-favorite-outline"></i> -->
          </a>
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
    <div class="wrap-icon-header flex-w flex-r-m m-r-15">
      <div
              class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 js-show-modal-search"
      >
        <i class="zmdi zmdi-search"></i>
      </div>

      <div
              class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti js-show-cart cart-count"
              data-notify="2"
      >
        <i class="zmdi zmdi-shopping-cart"></i>
      </div>

      <a
              href="#"
              class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti"
              data-notify="0"
      >
        <i class="zmdi zmdi-favorite-outline"></i>
      </a>
      <%--      <p style="cursor: pointer;" href=""class="flex-c-m trans-04 p-lr-25"  onClick="removeCookieAndReload();"><i style="color: red;font-size:24px;" class="fa fa-sign-out" ></i></p>--%>

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
    <ul class="topbar-mobile">
      <li>
        <div class="left-top-bar">
          Free shipping for standard order over $100
        </div>
      </li>

      <li>
        <div class="right-top-bar flex-w h-full">
          <a href="#" class="flex-c-m p-lr-10 trans-04"> Help & FAQs </a>
          <c:choose>
            <c:when test="${not empty sessionScope.currentUser}">
              <a

                      href="front?controller=RegisterController"
                      class="flex-c-m p-lr-10 trans-04"
              >
                My Account
              </a>
            </c:when>
            <c:otherwise>
              <a

                      href="front?controller=RegisterController"
                      class="flex-c-m p-lr-10 trans-04"
              >
                Register
              </a>
            </c:otherwise>
          </c:choose>


          <a href="#" class="flex-c-m p-lr-10 trans-04"> EN </a>

          <a href="#" class="flex-c-m p-lr-10 trans-04"> USD </a>
        </div>
      </li>
    </ul>

    <ul class="main-menu-m">
      <li>
        <a href="front?controller=LoginController">Login</a>
      </li>

      <li>
        <a href="front?controller=HomeController">Home</a>
        <!-- <ul class="sub-menu-m">
          <li><a href="../index.html">Homepage 1</a></li>
          <li><a href="home-02.html">Homepage 2</a></li>
          <li><a href="home-03.html">Homepage 3</a></li>
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
  <!-- <div class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
    <div class="container-search-header">
      <button
        class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search"
      >
        <img src="assets/images/icons/icon-close2.png" alt="CLOSE" />
      </button>

      <form class="wrap-search-header flex-w p-l-15" action="front?controller=HomeController" method="GET">
        <button class="flex-c-m trans-04" type="submit">
            <i class="zmdi zmdi-search"></i>
        </button>
        <input class="plh3" type="text" name="search" placeholder="Search..." />
    </form>
    </div> -->
  </div>
  <script defer src="assets/customJS/cartProducts.js"></script>
  <script defer src="assets/customJS/header.js"></script>
  <script defer src="assets/customJS/sessionStatus.js"></script>
  <script>
    function removeCookieAndReload() {
      // window.location.href  = "http://localhost:9090/ecommerce/front?controller=LogOutController";
    }
  </script>
</header>
