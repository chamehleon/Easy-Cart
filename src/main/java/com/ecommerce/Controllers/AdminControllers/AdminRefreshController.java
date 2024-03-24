package com.ecommerce.Controllers.AdminControllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Set;

public class AdminRefreshController implements IController {

    private static AdminRefreshController instance;

    private AdminRefreshController() {
    }

    public static AdminRefreshController getInstance() {
        if (instance == null) {
            instance = new AdminRefreshController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        try {
            String method = request.getMethod();
            if (method.equals("GET")) {
//                String webXmlPath = request.getServletContext().getRealPath("/WEB-INF/web.xml");
//                Files.setLastModifiedTime(Path.of(webXmlPath), FileTime.from(Instant.now()));
//                resolver.forward(ResourcePathMapper.PAGE_ADMIN.getPath());
//                response.setContentType("text/event-stream");
//                response.getWriter().write("event: refresh\ndata: {}\n\n");

                }
            } catch (Exception e)

                {
                    e.printStackTrace();
                }
        return resolver;


    }

}
