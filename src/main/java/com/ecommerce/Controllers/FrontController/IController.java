package com.ecommerce.Controllers.FrontController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IController {
    ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response);

}
