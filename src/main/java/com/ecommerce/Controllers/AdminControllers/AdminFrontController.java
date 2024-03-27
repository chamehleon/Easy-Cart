package com.ecommerce.Controllers.AdminControllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;

public class AdminFrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        processRequest(req, resp);
    }

    private void processRequest(final HttpServletRequest request, final HttpServletResponse response) {
        String controllerName = request.getParameter("controller");
        if(controllerName ==null ) controllerName = "AdminController"; 
        System.out.println(" Controller is: " + controllerName);
        System.out.println("isssssss");

        AdminControllerFactory factory = AdminControllerFactory.getInstance();
        IController controller = factory.getController(controllerName);
        ViewResolver resolver = controller.resolve(request, response);
        try {
            dispatch(request, response, resolver);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void dispatch(final HttpServletRequest request, final HttpServletResponse response,
                          final ViewResolver resolver) throws ServletException, IOException {
        String view = resolver.getView();
        System.out.println("VIEWWWWWWWWW" + view);
        switch (resolver.getResolveAction()) {
            case FORWARD:
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(view);
                dispatcher.forward(request, response);
                break;
            case INCLUDE:
                RequestDispatcher includeDispatcher = getServletContext().getRequestDispatcher(view);
                includeDispatcher.include(request, response);
                break;
            case REDIRECT:
                String contextPath = request.getContextPath();
                System.out.println("context path: " + contextPath);
                view = contextPath + "/Admin?controller=" +view;
                response.sendRedirect(view);
                break;
            case PLAIN_TEXT:
                response.setContentType("plain/text");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(view);
                break;
            case JSON:
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(view);
            default:
                break;
        }
    }

}
