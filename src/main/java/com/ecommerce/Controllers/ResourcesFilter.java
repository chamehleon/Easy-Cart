package com.ecommerce.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ResourcesFilter {
    private static final List<String> STATIC_RESOURCE_PREFIXES = Arrays.asList("/css/", "/js/", "customJS", "vendor", "/images/", "jquery-ui-datepicker", "webfonts", "/audio/", "/video/", "/webfonts/", "/fonts/", "/img/");
    private static final List<String> STATIC_RESOURCE_SUFFIX = Arrays.asList(".jsp", ".html");

    public boolean handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        System.out.println("mostagfa  " +request.getRequestURI());
        System.out.println("Path: " + path);

        if (path != null && (STATIC_RESOURCE_PREFIXES.stream().anyMatch(path::startsWith) || STATIC_RESOURCE_SUFFIX.stream().anyMatch(path::endsWith))) {
            request.getServletContext().getRequestDispatcher(path).forward(request, response);
            return true;
        }


        return false;
    }
}