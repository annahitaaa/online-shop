package org.example.data;

import org.example.data.entities.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CartDAOImpl implements CartDAO {

    @Override
    public Cart findUserBycartId(long cartId) {
        return null;
    }

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Cart cart) {
        entityManager.persist(cart);
        entityManager.close();
    }

    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Cart find(long id) {
        Cart cart = entityManager.find(Cart.class,  id);
        entityManager.close();
        return cart;

    }
}
