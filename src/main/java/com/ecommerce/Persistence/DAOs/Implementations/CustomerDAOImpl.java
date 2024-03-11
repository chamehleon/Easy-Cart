package com.ecommerce.Persistence.DAOs.Implementations;

import com.ecommerce.Persistence.DAOs.GenericDAOs.GenericDAOImpl;
import com.ecommerce.Persistence.DAOs.GenericDAOs.GenericDAOInt;
import com.ecommerce.Persistence.Entities.Customer;
//import com.ecommerce.Persistence.PersistenceManager;
import com.ecommerce.Utils.EntityManagerThreadLocalUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class CustomerDAO extends GenericDAOImpl<Customer, Integer> {
    private final static int pageSize = 5;

    public CustomerDAO( EntityManager entityManager ) {
        super( Customer.class, entityManager );
        this.entityManager = entityManager;
    }

    public Optional<Customer> findUserByEmail( String email ) {
        Customer customer = null;
        email = email.toLowerCase();
        try {
            TypedQuery<Customer> query = entityManager.createQuery( "SELECT u FROM Customer u WHERE u.email = :email", Customer.class );
            query.setParameter( "email", email );
            customer = query.getSingleResult();
        } catch ( NoResultException nre ) {
            nre.printStackTrace();
        }
        return Optional.ofNullable( customer );
    }

    public Optional<User> findUserByConfirmationId( String confirmationId ) {
        User user = null;
        try {
            TypedQuery<User> query = entityManager.createQuery( "SELECT u FROM User u WHERE u.confirmationId = :confirmationId", User.class );
            query.setParameter( "confirmationId", confirmationId );
            user = query.getSingleResult();
        } catch ( NoResultException nre ) {
            nre.printStackTrace();
        }
        return Optional.ofNullable( user );
    }


    public List<User> getPage( int pageNumber ) {
        TypedQuery<User> query = entityManager.createQuery( "FROM User u where u.role = 'CUSTOMER' ", User.class );
        return query.setFirstResult( ( pageNumber - 1 ) * pageSize )
                .setMaxResults( pageSize )
                .getResultList();
    }


    public long getNumberOfPages() {
        Query queryTotal = entityManager.createQuery( "SELECT COUNT(u.id) FROM User u where u.role = 'CUSTOMER' " );
        long countResult = (long) queryTotal.getSingleResult();

        long finalPage = ( countResult % pageSize > 0 ? 1 : 0 );

        return ( countResult / pageSize ) + finalPage;
    }
}





//public class CustomerDAOImpl implements CustomerDAO {
//
//   // public static EntityManager entityManager = PersistenceManager.getEntityManager();
//    @Override
//    public boolean insert(Customer entity) {
//        EntityManager entityManager = EntityManagerThreadLocalUtil.getEntityManager();
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.persist(entity);
//            entityManager.getTransaction().commit();
//        } catch (RuntimeException e) {
//            if (entityManager.getTransaction().isActive()) {
//                entityManager.getTransaction().rollback();
//            }
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public Customer get(int key) {
//        EntityManager entityManager = EntityManagerThreadLocalUtil.getEntityManager();
//        Customer customer = null;
//        try {
//            customer = entityManager.find(Customer.class, key);
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }
//        return customer;
//    }
//
//    @Override
//    public void update(Customer entity) {
//        EntityManager entityManager = EntityManagerThreadLocalUtil.getEntityManager();
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.merge(entity);
//            entityManager.getTransaction().commit();
//        } catch (RuntimeException e) {
//            if (entityManager.getTransaction().isActive()) {
//                entityManager.getTransaction().rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(Customer entity) {
//        EntityManager entityManager = EntityManagerThreadLocalUtil.getEntityManager();
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
//            entityManager.getTransaction().commit();
//        } catch (RuntimeException e) {
//            if (entityManager.getTransaction().isActive()) {
//                entityManager.getTransaction().rollback();
//            }
//            e.printStackTrace();
//        }
//    }

//}
