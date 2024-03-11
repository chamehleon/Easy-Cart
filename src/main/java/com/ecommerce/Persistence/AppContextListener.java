package com.ecommerce.Persistence;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.spi.PersistenceProvider;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String puName = "pu-name";
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.format_sql", "true");

        PersistenceProvider provider = new HibernatePersistenceProvider();
        EntityManagerFactory emf = provider.createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        ServletContext sc = sce.getServletContext();
        sc.setAttribute("EntityManagerFactory", emf);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        EntityManagerFactory emf = (EntityManagerFactory) sc.getAttribute("EntityManagerFactory");
        emf.close();
    }
}
