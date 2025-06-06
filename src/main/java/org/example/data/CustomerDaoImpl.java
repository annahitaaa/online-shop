package org.example.data;

import org.example.data.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    SessionFactory sessionFactory;

    @PersistenceContext
    EntityManager entityManager;



    @Override
    public void save(Customer customer) {
        Session session = sessionFactory.openSession();
        session.save(customer);
        session.close();
    }

    @Override
    public Customer findUserByusername(String username) {
        return (Customer) entityManager.createQuery("from Customer c where c.username =:username").setParameter("username",username).getSingleResult();
    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("from Customer").getResultList();
    }

    @Override
    public Customer findOne(long customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        entityManager.close();
        return customer;
    }

    @Override
    public Customer findCustomerByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {
        entityManager.refresh(customer);
        entityManager.close();
    }
}
