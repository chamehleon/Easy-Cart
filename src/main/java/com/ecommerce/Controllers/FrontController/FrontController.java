package com.ecommerce.Controllers.FrontController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FrontController extends HttpServlet {
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
        System.out.println(" Controller is: " + controllerName);
        System.out.println(request.getPathInfo());
        System.out.println(request.getRequestURI());

        ControllerFactory factory = ControllerFactory.getInstance();
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
                view = contextPath + "/front?controller=" +view;
                response.sendRedirect(view);
                break;
            case PLAIN_TEXT:
                response.setContentType("plain/text");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(view);
            default:
                break;
        }
    }

}
