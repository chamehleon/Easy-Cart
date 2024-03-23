<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page
        language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@ page import="com.ecommerce.Persistence.Entities.Product" %>
<%@ page import="com.ecommerce.Persistence.Entities.Category" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Product Page - Admin HTML Template</title>
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
  <jsp:include page="header.jsp" />
    <div class="container mt-5">
      <div class="row tm-content-row">
        <div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col">
          <div class="tm-bg-primary-dark tm-block tm-block-products">
            <div class="tm-product-table-container">
              <table class="table table-hover tm-table-small tm-product-table">
                <thead>
                  <tr>
                    <th scope="col">&nbsp;</th>
                    <th scope="col">PRODUCT NAME</th>
                    <th scope="col">STOCK QUANTITY</th>
                    <th scope="col">PRICE</th>
                    <th scope="col">CATEGORY</th>
                    <th scope="col">&nbsp;</th>
                  </tr>
                </thead>
                <tbody>

                <c:forEach var="product" items="${products}">
                  <tr data-id="${product.id}"  data-href = "front?controller=AdminUpdateProductController&id=${product.id}">
                    <th scope="row"><input type="checkbox" /></th>
                    <td class="tm-product-name">${product.productName}</td>
                    <td>${product.stockQuantity}</td>
                    <td>${product.productPrice}</td>
                    <td>${product.category.categoryName}</td>
                    <td>
                      <a href="" class="tm-product-delete-link">
                        <i class="far fa-trash-alt tm-product-delete-icon"></i>
                      </a>
                    </td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>
            <!-- table container -->
            <a
              href="front?controller=AdminAddProductController"
              class="btn btn-primary btn-block text-uppercase mb-3">Add new product</a>
            <button class="btn btn-primary btn-block text-uppercase">
              Delete selected products
            </button>
          </div>
        </div>
        <div class="col-sm-12 col-md-12 col-lg-4 col-xl-4 tm-block-col">
          <div class="tm-bg-primary-dark tm-block tm-block-product-categories">
            <h2 class="tm-block-title">Product Categories</h2>
            <div class="tm-product-table-container">
              <table class="table tm-table-small tm-product-table">
                <tbody>
                <c:forEach var="category" items="${categories}">
                  <tr>
                    <td class="tm-product-name">${category.categoryName}</td>
                    <td class="text-center">
                      <a href="#" class="tm-product-delete-link">
                        <i class="far fa-trash-alt tm-product-delete-icon"></i>
                      </a>
                    </td>
                  </tr>
                </c:forEach>

                </tbody>
              </table>
            </div>
            <!-- table container -->
            <button class="btn btn-primary btn-block text-uppercase mb-3">
              Add new category
            </button>
          </div>
        </div>
      </div>
    </div>
    <footer class="tm-footer row tm-mt-small">
      <div class="col-12 font-weight-light">
        <p class="text-center text-white mb-0 px-4 small">
          Copyright &copy; <b>2018</b> All rights reserved. 
          
          Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
        </p>
      </div>
    </footer>

    <script src="assets/adminAssets/js/jquery-3.3.1.min.js"></script>
    <!-- https://jquery.com/download/ -->
    <script src="assets/adminAssets/js/bootstrap.min.js"></script>
    <!-- https://getbootstrap.com/ -->
    <script>
      document.addEventListener("DOMContentLoaded", function() {
        var rows = document.querySelectorAll("tr[data-href]");
        rows.forEach(row => {
          row.addEventListener("click", function() {
            window.location.href = this.dataset.href;
          });
        });
      });

      $(function() {
        $(".tm-product-name").on("click", function() {
          window.location.href = "edit-product.jsp";
        });
      });
    </script>
  </body>
</html>