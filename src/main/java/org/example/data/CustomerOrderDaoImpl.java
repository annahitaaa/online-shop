package org.example.data;

import org.example.data.entities.Cart;
import org.example.data.entities.CustomerOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerOrderDaoImpl implements CustomerOrderDao {
    @Override
    public CustomerOrder getCustomerOrderBycart(Cart cart) {
        return null;
    }

    @Override
    public void save(CustomerOrder product) {

    }

    @Override
    public List<CustomerOrder> findAll() {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public CustomerOrder find(long id) {
        return null;
    }
}
