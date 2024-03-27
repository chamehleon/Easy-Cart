<jsp:useBean id="customers" scope="request" type="java.util.List"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page
        language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@ page import="com.ecommerce.Persistence.Entities.Customer" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Accounts - Product Admin Template</title>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Roboto:400,700"
    />
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link rel="stylesheet" href="assets/adminAssets/css/fontawesome.min.css" />
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="assets/adminAssets/css/bootstrap.min.css" />
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="assets/adminAssets/css/templatemo-style.css">
    <!--
	Product Admin CSS Template
	https://templatemo.com/tm-524-product-admin
	-->
  </head>

  <body id="reportsPage">
    <div class="" id="home">
      <jsp:include page="header.jsp">
        <jsp:param name="active" value="accounts" />
      </jsp:include>
      <div class="container mt-5">
        <div class="tm-product-table-container">
          <table class="table table-hover tm-table-small tm-product-table">
            <thead>
            <tr>
              <th scope="col">&nbsp;</th>
              <th scope="col">Customer name</th>
              <th scope="col">Birthday</th>
              <th scope="col">job</th>
              <th scope="col">email</th>
              <th scope="col">Credit Limit</th>
              <th scope="col">City</th>

            </tr>
            </thead>
            <tbody>


            <c:forEach var="customer" items="${customers}">
              <tr>
                <th scope="row"><input type="checkbox" /></th>
                <td class="tm-product-name">${customer.customerName}</td>
                <td>${customer.birthday}</td>
                <td>${customer.job}</td>
                <td>${customer.email}</td>
                <td>${customer.creditLimit}</td>
                <td>${customer.city}</td>
                <td class="center-button">
                  <a href="Admin?controller=AdminOrderHistoryController&customerId=${customer.id}" class="btn btn-primary btn-small text-uppercase mb-3">
                    Get Order History
                  </a>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
        <!-- row -->
<%--        <div class="row tm-content-row">--%>
<%--          <div class="tm-block-col tm-col-avatar">--%>
<%--            <div class="tm-bg-primary-dark tm-block tm-block-avatar">--%>
<%--              <h2 class="tm-block-title">Change Avatar</h2>--%>
<%--              <div class="tm-avatar-container">--%>
<%--                <img--%>
<%--                  src="assets/adminAssets/img/avatar.png"--%>
<%--                  alt="Avatar"--%>
<%--                  class="tm-avatar img-fluid mb-4"--%>
<%--                />--%>
<%--                <a href="#" class="tm-avatar-delete-link">--%>
<%--                  <i class="far fa-trash-alt tm-product-delete-icon"></i>--%>
<%--                </a>--%>
<%--              </div>--%>
<%--              <button class="btn btn-primary btn-block text-uppercase">--%>
<%--                Upload New Photo--%>
<%--              </button>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--          <div class="tm-block-col tm-col-account-settings">--%>
<%--            <div class="tm-bg-primary-dark tm-block tm-block-settings">--%>
<%--              <h2 class="tm-block-title">Account Settings</h2>--%>
<%--              <form action="" class="tm-signup-form row">--%>
<%--                <div class="form-group col-lg-6">--%>
<%--                  <label for="name">Account Name</label>--%>
<%--                  <input--%>
<%--                    id="name"--%>
<%--                    name="name"--%>
<%--                    type="text"--%>
<%--                    class="form-control validate"--%>
<%--                  />--%>
<%--                </div>--%>
<%--                <div class="form-group col-lg-6">--%>
<%--                  <label for="email">Account Email</label>--%>
<%--                  <input--%>
<%--                    id="email"--%>
<%--                    name="email"--%>
<%--                    type="email"--%>
<%--                    class="form-control validate"--%>
<%--                  />--%>
<%--                </div>--%>
<%--                <div class="form-group col-lg-6">--%>
<%--                  <label for="password">Password</label>--%>
<%--                  <input--%>
<%--                    id="password"--%>
<%--                    name="password"--%>
<%--                    type="password"--%>
<%--                    class="form-control validate"--%>
<%--                  />--%>
<%--                </div>--%>
<%--                <div class="form-group col-lg-6">--%>
<%--                  <label for="password2">Re-enter Password</label>--%>
<%--                  <input--%>
<%--                    id="password2"--%>
<%--                    name="password2"--%>
<%--                    type="password"--%>
<%--                    class="form-control validate"--%>
<%--                  />--%>
<%--                </div>--%>
<%--                <div class="form-group col-lg-6">--%>
<%--                  <label for="phone">Phone</label>--%>
<%--                  <input--%>
<%--                    id="phone"--%>
<%--                    name="phone"--%>
<%--                    type="tel"--%>
<%--                    class="form-control validate"--%>
<%--                  />--%>
<%--                </div>--%>
<%--                <div class="form-group col-lg-6">--%>
<%--                  <label class="tm-hide-sm">&nbsp;</label>--%>
<%--                  <button--%>
<%--                    type="submit"--%>
<%--                    class="btn btn-primary btn-block text-uppercase"--%>
<%--                  >--%>
<%--                    Update Your Profile--%>
<%--                  </button>--%>
<%--                </div>--%>
<%--                <div class="col-12">--%>
<%--                  <button--%>
<%--                    type="submit"--%>
<%--                    class="btn btn-primary btn-block text-uppercase"--%>
<%--                  >--%>
<%--                    Delete Your Account--%>
<%--                  </button>--%>
<%--                </div>--%>
<%--              </form>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--        </div>--%>
      </div>
      <footer class="tm-footer row tm-mt-small">
        <div class="col-12 font-weight-light">
          <p class="text-center text-white mb-0 px-4 small">
            Copyright &copy; <b>2018</b> All rights reserved. 
            
            Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
          </p>
        </div>
      </footer>
    </div>

    <script src="assets/adminAssets/js/jquery-3.3.1.min.js"></script>
    <!-- https://jquery.com/download/ -->
    <script src="assets/adminAssets/js/bootstrap.min.js"></script>
    <!-- https://getbootstrap.com/ -->
  </body>
</html>
