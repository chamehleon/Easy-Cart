package com.ecommerce.Utils;

public enum ResourcePathMapper {
    PAGE_HOME("/index.jsp"),
    PAGE_LOGIN("/pages/login.jsp"),
    PAGE_REGISTER("/pages/register.jsp"),
    PAGE_CART("/pages/shoping-cart.jsp"),
    PAGE_PRODUCT("/pages/product.jsp"),
    PAGE_CONTACT("/pages/contact.jsp"),
    PAGE_BLOG("/pages/blog.jsp"),
    PAGE_BLOG_DETAIL("/pages/blog-detail.jsp"),
    PAGE_PRODUCT_DETAIL("/pages/product-detail.jsp"),
    PAGE_CHECKOUT("/pages/checkout.jsp"),
    PAGE_ORDER("/pages/order.jsp"),
    PAGE_ORDER_HISTORY("/pages/orderHistory.jsp"),
    PAGE_PRODUCT_MANAGEMENT("/pages/productManagement.jsp"),
    PAGE_USER_MANAGEMENT("/pages/userManagement.jsp"),
    PAGE_ORDER_MANAGEMENT("/pages/orderManagement.jsp"),
    PAGE_ABOUT("/pages/about.jsp"),
    PAGE_CHECKOUT_SUCCESS("/pages/checkout-success.jsp"),

    PAGE_ADMIN("/pages/admin/index.jsp"),
    PAGE_ADMIN_PRODUCT("/pages/admin/products.jsp"),


    PAGE_ADMIN_ADD_PRODUCT("/pages/admin/add-product.jsp"),
    PAGE_ADMIN_VIEW_PRODUCT("/pages/admin/edit-product.jsp"),

    ADMIN_PRODUCT_CONTROLLER("AdminProductsController"),
    PAGE_ADMIN_ACCOUNTS("/pages/admin/accounts.jsp"),
    PAGE_ADMIN_ORDER_HISTORY("/pages/admin/order-history.jsp"),

    PAGE_ORDER_ERROR("/pages/order-error.html"),

    HOME_CONTROLLER("HomeController"),
    PAGE_ERROR("/pages/error.jsp");



    private final String path;

    ResourcePathMapper(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}