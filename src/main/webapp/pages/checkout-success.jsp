<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="com.ecommerce.Persistence.Entities.Order" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Contact</title>
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
     <style>
        .containerzz {
            margin: 0 auto;
            width: 50%;
        }
        .h1 {
  font-size: 24px;
  margin-bottom: 10px;
  color: #4CAF50;
}

.para {
  line-height: 1.5;
}

.anchor {
  background-color: #4CAF50;
  color: white;
  padding: 10px 15px;
  text-decoration: none;
  display: inline-block;
  margin-top: 20px;
}

.anchor:hover {
    color: white;
    background-color: #2e6b30;
}
         .green-tick {
            width: 100px;
            height: 100px;
            margin: 0 auto;
            display: block;
         }
  
</style> 

    
  </head>
  <body class="animsition">
   
    <jsp:include page="header.jsp">
        <jsp:param name="active" value="sdsd" />
      </jsp:include>

      <jsp:include page="viewCart.jsp"></jsp:include>
   

    <!-- Content page -->
    <section class="bg0 p-t-104 p-b-116">
      <div class="container some-height">
        <div class="flex-w flex-tr">
            <div class="containerzz">

                <img class="green-tick" src="assets/images/icons/green-tick.jpg" alt="success" />
                <h1 class="h1">Purchase successful!</h1>

                <p class="para">Your order number is: <b>${sessionScope.orderID}</b></p>
                <p class="para">You will receive an order confirmation email with details of your order and a link to track its progress.</p>
                <p class="para">All necessary information about the delivery, we sent to your email.</p>
                <a class="anchor flex-c-m stext-101 cl2 size-115 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer" href="front?controller=FetchProducts">CONTINUE SHOPPING</a>
              </div>
        </div>
        </div>
      </div>
    </section>

    <!-- Footer -->
    <jsp:include page="footer.jsp" />

    <!-- Back to top -->
    <!-- <div class="btn-back-to-top" id="myBtn">
      <span class="symbol-btn-back-to-top">
        <i class="zmdi zmdi-chevron-up"></i>
      </span>
    </div> -->

    <!--===============================================================================================-->
    <script defer src="assets/customJS/sessionStatus.js"></script>
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
