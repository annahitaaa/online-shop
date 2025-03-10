package org.example.data;

import org.example.data.ProductDAO;
import org.example.data.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    SessionFactory sessionFactory;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Product product) {
        Session session = getSession();
        session.save(product);
        session.close();
    }

    @Override
    public List<Product> findAll() {
        try (Session session = getSession()) {
            Query from_product = session.createQuery("from Product");
            List<Product> list = from_product.list();
            session.close();
            return list;
        }
    }

    @Override
    public void delete(int id) {
        Session session = getSession();
        Product p = session.get(Product.class, id);
        session.delete(p);
        session.flush();
    }

    @Override
    public Product find(long productId) {
        Product product = entityManager.find(Product.class, productId);
        entityManager.close();
        return product;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }


}
