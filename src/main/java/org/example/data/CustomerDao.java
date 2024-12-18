package org.example.data;

import org.example.data.entities.Customer;

import java.util.List;

public interface CustomerDao {
    public void save(Customer customer);
    public Customer findUserByusername(String username);

    List<Customer> findAll();

    public Customer findOne(long customerId);

    Customer findCustomerByUsernameAndPassword(String username, String password);
}
