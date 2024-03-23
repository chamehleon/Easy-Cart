<jsp:useBean id="orders" scope="request" type="java.util.List"/>
<jsp:useBean id="customer" scope="request" type="com.ecommerce.Persistence.Entities.Customer"/>
<jsp:useBean id="orderTotals" scope="request" type="java.util.List"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page
        language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@ page import="com.ecommerce.Persistence.Entities.Customer" %>
<%@ page import="com.ecommerce.Persistence.Entities.Order" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Product Admin - Dashboard HTML Template</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link rel="stylesheet" href="assets/adminAssets/css/fontawesome.min.css">
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="assets/adminAssets/css/bootstrap.min.css">
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="assets/adminAssets/css/templatemo-style.css">
    <!--
	Product Admin CSS Template
	https://templatemo.com/tm-524-product-admin
	-->
</head>

<body id="reportsPage">
<div class="" id="home">
    <jsp:include page="header.jsp" />
    <div class="container">
        <div class="row">
            <div class="col">
                <p class="text-white mt-5 mb-5">Welcome back, <b>Admin</b></p>
            </div>
        </div>
        <!-- row -->
        <div class="row tm-content-row">


            <div class="col-12 tm-block-col">
                <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
                    <h2 class="tm-block-title">Orders List</h2>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">ORDER NO.</th>
                            <th scope="col">CUSTOMER</th>
                            <th scope="col">ORDERED AT</th>
                            <th scope="col">COUNTRY</th>
                            <th scope="col">CITY</th>
                            <th scope="col">TOTAL</th>
                            <th scope="col">EST DELIVERY DUE</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="order" items="${orders}" varStatus="status">
                            <tr>
                                <th scope="row"><b>${order.id}</b></th>
                                <td><b>${customer.customerName}</b></td>
                                <td><b>${order.orderedAt}</b></td>
                                <td><b>${customer.country}</b></td>
                                <td><b>${customer.city}</b></td>
                                <td><b>${orderTotals[status.index]}</b></td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
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
</div>

<script src="assets/adminAssets/js/jquery-3.3.1.min.js"></script>
<!-- https://jquery.com/download/ -->
<script src="assets/adminAssets/js/moment.min.js"></script>
<!-- https://momentjs.com/ -->
<script src="assets/adminAssets/js/Chart.min.js"></script>
<!-- http://www.chartjs.org/docs/latest/ -->
<script src="assets/adminAssets/js/bootstrap.min.js"></script>
<!-- https://getbootstrap.com/ -->
<script src="assets/adminAssets/js/tooplate-scripts.js"></script>
<script>
    Chart.defaults.global.defaultFontColor = 'white';
    let ctxLine,
        ctxBar,
        ctxPie,
        optionsLine,
        optionsBar,
        optionsPie,
        configLine,
        configBar,
        configPie,
        lineChart;
    barChart, pieChart;
    // DOM is ready
    $(function () {
        drawLineChart(); // Line Chart
        drawBarChart(); // Bar Chart
        drawPieChart(); // Pie Chart

        $(window).resize(function () {
            updateLineChart();
            updateBarChart();
        });
    })
</script>
</body>

</html>