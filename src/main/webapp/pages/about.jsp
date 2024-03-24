<!DOCTYPE html>
<html lang="en">
  <head>
    <title>About</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="assets/images/icons/favicon.png" />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="assets/vendor/bootstrap/css/bootstrap.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="assets/fonts/iconic/css/material-design-iconic-font.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="assets/fonts/linearicons-v1.0.0/icon-font.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="assets/vendor/animate/animate.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="assets/vendor/css-hamburgers/hamburgers.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="assets/vendor/animsition/css/animsition.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="assets/vendor/select2/select2.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="assets/vendor/perfect-scrollbar/perfect-scrollbar.css"
    />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="assets/css/util.css" />
    <link rel="stylesheet" type="text/css" href="assets/css/main.css" />
    <!--===============================================================================================-->
  </head>
  <body class="animsition">
    <!-- Header -->
    <jsp:include page="header.jsp">
      <jsp:param name="active" value="about" />
    </jsp:include>

    <!-- Cart -->
    <div class="wrap-header-cart js-panel-cart">
      <div class="s-full js-hide-cart"></div>

      <div class="header-cart flex-col-l p-l-65 p-r-25">
        <div class="header-cart-title flex-w flex-sb-m p-b-8">
          <span class="mtext-103 cl2"> Your Cart </span>

          <div
            class="fs-35 lh-10 cl2 p-lr-5 pointer hov-cl1 trans-04 js-hide-cart"
          >
            <i class="zmdi zmdi-close"></i>
          </div>
        </div>

        <div class="header-cart-content flex-w js-pscroll">
          <ul class="header-cart-wrapitem w-full">
            <li class="header-cart-item flex-w flex-t m-b-12">
              <div class="header-cart-item-img">
                <img src="assets/images/item-cart-01.jpg" alt="IMG" />
              </div>

              <div class="header-cart-item-txt p-t-8">
                <a
                  href="#"
                  class="header-cart-item-name m-b-18 hov-cl1 trans-04"
                >
                  White Shirt Pleat
                </a>

                <span class="header-cart-item-info"> 1 x $19.00 </span>
              </div>
            </li>

            <li class="header-cart-item flex-w flex-t m-b-12">
              <div class="header-cart-item-img">
                <img src="assets/images/item-cart-02.jpg" alt="IMG" />
              </div>

              <div class="header-cart-item-txt p-t-8">
                <a
                  href="#"
                  class="header-cart-item-name m-b-18 hov-cl1 trans-04"
                >
                  Converse All Star
                </a>

                <span class="header-cart-item-info"> 1 x $39.00 </span>
              </div>
            </li>

            <li class="header-cart-item flex-w flex-t m-b-12">
              <div class="header-cart-item-img">
                <img src="assets/images/item-cart-03.jpg" alt="IMG" />
              </div>

              <div class="header-cart-item-txt p-t-8">
                <a
                  href="#"
                  class="header-cart-item-name m-b-18 hov-cl1 trans-04"
                >
                  Nixon Porter Leather
                </a>

                <span class="header-cart-item-info"> 1 x $17.00 </span>
              </div>
            </li>
          </ul>

          <div class="w-full">
            <div class="header-cart-total w-full p-tb-40">Total: $75.00</div>

            <div class="header-cart-buttons flex-w w-full">
              <a
                href="shoping-cart.jsp"
                class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10"
              >
                View Cart
              </a>

              <a
                href="shoping-cart.jsp"
                class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-b-10"
              >
                Check Out
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Title page -->
    <section
      class="bg-img1 txt-center p-lr-15 p-tb-92"
      style="background-image: url('assets/images/bg-01.jpg')"
    >
      <h2 class="ltext-105 cl0 txt-center">About</h2>
    </section>

    <!-- Content page -->
    <section class="bg0 p-t-75 p-b-120">
      <div class="container">
        <div class="row p-b-148">
          <div class="col-md-7 col-lg-8">
            <div class="p-t-7 p-r-85 p-r-15-lg p-r-0-md">
              <h3 class="mtext-111 cl2 p-b-16">Our Story</h3>

              <p class="stext-113 cl6 p-b-26">
                Welcome to MAEVE Online, your destination for contemporary
                fashion that captures the essence of modern sophistication.
                Immerse yourself in a world where every garment tells a story,
                curated to elevate your style effortlessly. Discover our latest
                collections, meticulously crafted to embody elegance and
                versatility. From timeless staples to on-trend pieces, MAEVE
                offers a curated selection that resonates with your
                individuality. Indulge in the luxury of choice with our diverse
                range of accessories. Elevate your look with statement jewelry,
                chic handbags, and accessories that add a touch of glamour to
                any outfit.
              </p>

              <p class="stext-113 cl6 p-b-26">
                Shopping at MAEVE is a seamless experience, designed to cater to
                your needs. Browse our user-friendly website to explore our
                curated collections and find your perfect ensemble with ease.
                With convenient delivery options, your favorite pieces are just
                a click away.
              </p>

              <p class="stext-113 cl6 p-b-26">
                Have questions or need assistance? Our dedicated team is here to
                help. Visit us at our flagship store on the 8th floor, 379
                Hudson St, New York, NY 10018, or contact us at (+1) 96 716
                6879. Experience the essence of style with MAEVE.
              </p>
            </div>
          </div>

          <div class="col-11 col-md-5 col-lg-4 m-lr-auto">
            <div class="how-bor1">
              <div class="hov-img0">
                <img src="assets/images/about-01.jpg" alt="IMG" />
              </div>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="order-md-2 col-md-7 col-lg-8 p-b-30">
            <div class="p-t-7 p-l-85 p-l-15-lg p-l-0-md">
              <h3 class="mtext-111 cl2 p-b-16">Our Mission</h3>

              <p class="stext-113 cl6 p-b-26">
                At MAEVE, we redefine modern fashion, inspiring confidence
                through curated collections. Crafted with quality and timeless
                design, we offer an exceptional shopping experience. With
                innovation and creativity, we evolve to meet diverse needs.
                Embracing individuality and inclusivity, we foster a community
                where all feel valued. Join us in shaping a limitless world of
                style. Welcome to MAEVE - Where Every Garment Tells a Story.
              </p>

              <div class="bor16 p-l-29 p-b-9 m-t-22">
                <p class="stext-114 cl6 p-r-40 p-b-11">
                  Creativity is just connecting things. When you ask creative
                  people how they did something, they feel a little guilty
                  because they didn't really do it, they just saw something. It
                  seemed obvious to them after a while.
                </p>

                <span class="stext-111 cl8"> - Steve Jobs </span>
              </div>
            </div>
          </div>

          <div class="order-md-1 col-11 col-md-5 col-lg-4 m-lr-auto p-b-30">
            <div class="how-bor2">
              <div class="hov-img0">
                <img src="assets/images/about-02.jpg" alt="IMG" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Footer -->
    <jsp:include page="footer.jsp" />

    <!-- Back to top -->
    <div class="btn-back-to-top" id="myBtn">
      <span class="symbol-btn-back-to-top">
        <i class="zmdi zmdi-chevron-up"></i>
      </span>
    </div>

    <!--===============================================================================================-->
    <script src="assets/customJS/sessionStatus.js"></script>
    <!--===============================================================================================-->
    <script src="assets/vendor/jquery/jquery-3.2.1.min.js"></script>
    <!--===============================================================================================-->
    <script src="assets/vendor/animsition/js/animsition.min.js"></script>
    <!--===============================================================================================-->
    <script src="assets/vendor/bootstrap/js/popper.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
    <!--===============================================================================================-->
    <script src="assets/vendor/select2/select2.min.js"></script>
    <script>
      $(".js-select2").each(function () {
        $(this).select2({
          minimumResultsForSearch: 20,
          dropdownParent: $(this).next(".dropDownSelect2"),
        });
      });
    </script>
    <!--===============================================================================================-->
    <script src="assets/vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
    <!--===============================================================================================-->
    <script src="assets/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
    <script>
      $(".js-pscroll").each(function () {
        $(this).css("position", "relative");
        $(this).css("overflow", "hidden");
        var ps = new PerfectScrollbar(this, {
          wheelSpeed: 1,
          scrollingThreshold: 1000,
          wheelPropagation: false,
        });

        $(window).on("resize", function () {
          ps.update();
        });
      });
    </script>
    <!--===============================================================================================-->
    <script src="assets/js/main.js"></script>
  </body>
</html>
