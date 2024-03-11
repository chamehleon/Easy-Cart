package com.ecommerce.Utils;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ThreadsOff implements ServletContextListener {

    private HikariDataSource dataSource;
    public ThreadsOff(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void contextInitialized(ServletContextEvent sce) {

    }

    public void contextDestroyed(ServletContextEvent sce) {
        JpaTransactionManager.close();
        AbandonedConnectionCleanupThread.checkedShutdown();


        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
        System.out.println("CLOSED from ThreadsOff");
    }

}
