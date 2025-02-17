package org.example.data;


import org.example.data.entities.Cart;
import org.example.data.entities.CustomerOrder;

import java.util.List;

public interface CustomerOrderDao{

	CustomerOrder getCustomerOrderBycart(Cart cart);

	void save(CustomerOrder product);

	List<CustomerOrder> findAll();

	void delete(long id);

	CustomerOrder find(long id);
}
