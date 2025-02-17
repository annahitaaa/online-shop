package org.example.data;

import org.example.data.entities.Cart;

import java.util.List;

public interface CartDAO {

    Cart findUserBycartId(long cartId);

    void save(Cart cart);

    List<Cart> findAll();

    void delete(long id);

    Cart find(long id);
}

