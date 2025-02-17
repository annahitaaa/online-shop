package org.example.data;

import org.example.data.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UsersDAOImpl implements UsersDAO {

    @Autowired
    SessionFactory sessionFactory;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Users user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }
}
