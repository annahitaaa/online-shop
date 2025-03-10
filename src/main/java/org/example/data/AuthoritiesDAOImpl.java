package org.example.data;

import org.example.data.entities.Authorities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO {
    @Autowired
    SessionFactory sessionFactory;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Authorities authorities) {
        Session session = sessionFactory.openSession();
        session.save(authorities);
        session.close();

    }
}
