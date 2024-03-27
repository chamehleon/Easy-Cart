<%@ page import="com.ecommerce.Persistence.DTOs.CustomerDTO" %>
<% CustomerDTO customer =   (CustomerDTO)session.getAttribute("currentUser"); %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="icon"
      type="image/png"
      href="assets/images/icons/favicon.png"
    />
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
      href="assets/vendor/daterangepicker/daterangepicker.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="assets/vendor/slick/slick.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="assets/vendor/MagnificPopup/magnific-popup.css"
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
    <title>User Registration</title>
    <style>
      .custom {
        display: flex;
        justify-content: center;
        align-items: center;
      }
    
    </style>
  </head>

  <body>
    <jsp:include page="header.jsp" />
 
    <section class="bg0 p-t-104 p-b-116">

  <section class="bg0 p-t-10 p-b-116">
    <div class="container">
      <div class="row ">
        <div class="col-3">
          <h4 id="MyProfileButton" class="bor10 mtext-105 cl2 txt-center p-t-10  p-b-10  " onclick="showUserData();"  style="cursor: pointer;">Profile Information</h4>
          <h4  id="MyOrderButton" class="bor10 mtext-105 cl2 txt-center p-t-10  p-b-10 mt-5" style="color :grey;cursor: pointer;" onclick="showOrders();">My Orders</h4> 
        </div>
        <div id="userData" class="col-9 flex-w flex-tr custom" >
          <div
            class="size-210 bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md"
          >
        <form  id="customerForm" method="post" action="?controller=UpdateUserInfoController">
          <h4 class="mtext-105 cl2 txt-center p-b-30">Profile Information</h4>
  
  
          <div class="bor8 m-b-20 how-pos4-parent">
            <input
              class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
              id="email"
              type="text"
              name="email"
              value="<%=  customer.getEmail()%>"
              disabled
            />
            <img
              class="how-pos4 pointer-none"
              src="assets/images/icons/icon-email.png"
              alt="ICON"
            />
          </div>
  
          <div class="bor8 m-b-20 how-pos4-parent">
            <input
              class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
              type="text"
              name="username"
              placeholder="username"
              value="<%=  customer.getCustomerName()%>"
            />
            <img
              class="how-pos4 pointer-none"
              src="assets/images/icons/icon-email.png"
              alt="ICON"
            />
          </div>
          <div class="bor8 m-b-20 how-pos4-parent">
            <input
              class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
              type="text"
              name="job"
              placeholder="job"
              value="<%=  customer.getJob()%>"
            />
            <img
              class="how-pos4 pointer-none"
              src="assets/images/icons/icon-email.png"
              alt="ICON"
            />
          </div>
          <div class="bor8 m-b-20 how-pos4-parent">
            <input
              class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
              type="text"
              name="birthdate"
              placeholder="birthdate"
              value="<%= customer.getBirthday().toString()  %>"
              disabled
            />
            <img
              class="how-pos4 pointer-none"
              src="assets/images/icons/icon-email.png"
              alt="ICON"
            />
          </div>
          <div class="bor8 m-b-20 how-pos4-parent">
            <input
              class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
              type="text"
              name="country"
              placeholder="country"
              value="<%= customer.getCountry() %>"
            />
            <img
              class="how-pos4 pointer-none"
              src="assets/images/icons/icon-email.png"
              alt="ICON"
            />
          </div>
          <div class="bor8 m-b-20 how-pos4-parent">
            <input
              class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
              type="text"
              name="city"
              placeholder="city"
              value="<%= customer.getCity() %>"
            />
            <img
              class="how-pos4 pointer-none"
              src="assets/images/icons/icon-email.png"
              alt="ICON"
            />
          </div>
          <div class="bor8 m-b-20 how-pos4-parent">
            <input
              class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
              type="text"
              name="streetName"
              value="<%= customer.getStreetName() %>"
              placeholder="Street Name"
            />
            <img
              class="how-pos4 pointer-none"
              src="assets/images/icons/icon-email.png"
              alt="ICON"
            />
          </div>
          <div class="bor8 m-b-20 how-pos4-parent">
            <input
              class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
              type="text"
              name="streetNo"
              placeholder="Street Number"
              value="<%= customer.getStreetNo() %>"
            />
            <img
              class="how-pos4 pointer-none"
              src="assets/images/icons/icon-email.png"
              alt="ICON"
            />
          </div>

          <button class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer">
            Update Profile
          </button>
      
        </form>
      </div>
    </div>
    <div id="orders" class="col-9" style="display: none;" > 


    </div>
      </div>
      
</section>


    </section>
    <jsp:include page="footer.jsp" />
  </body>

  <!-- <script defer src="assets/CustomJS/ajax.js"></script> -->
  <!--===============================================================================================-->
  <script defer src="assets/customJS/sessionStatus.js"></script>
  <script defer src="assets/customJS/updateUserScreen.js"></script>
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

  </script>
  <!--===============================================================================================-->
  <script src="assets/vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
  <!--===============================================================================================-->
  <script src="assets/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
  <script>
    
  </script>
  <script src="assets/js/main.js"></script>
</html>
