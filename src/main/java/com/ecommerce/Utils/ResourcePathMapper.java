package com.ecommerce.Utils;

public enum ResourcePathMapper {
    PAGE_HOME("/pages/home.jsp"),
    PAGE_LOGIN("/pages/login.jsp"),
    PAGE_REGISTER("/pages/register.jsp"),
    PAGE_CART("/pages/shoping-cart.html"),
    PAGE_PRODUCT("/pages/product.html"),
    PAGE_CHECKOUT("/pages/checkout.jsp"),
    PAGE_ORDER("/pages/order.jsp"),
    PAGE_ORDER_HISTORY("/pages/orderHistory.jsp"),
    PAGE_PRODUCT_MANAGEMENT("/pages/productManagement.jsp"),
    PAGE_USER_MANAGEMENT("/pages/userManagement.jsp"),
    PAGE_ORDER_MANAGEMENT("/pages/orderManagement.jsp"),
    PAGE_ABOUT("/pages/about.html"),
    PAGE_ERROR("/pages/error.html");

    private final String path;

    ResourcePathMapper(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}