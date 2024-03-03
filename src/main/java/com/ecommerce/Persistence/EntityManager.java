package com.ecommerce.Persistence;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManager {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU");

    EntityManager entityManager = (EntityManager) entityManagerFactory.createEntityManager();
}
