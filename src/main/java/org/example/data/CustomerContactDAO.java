package org.example.data;

import org.example.data.entities.CustomerContact;

import java.util.List;

public interface CustomerContactDAO {
    public void addNewMessage(CustomerContact customerContact);

    public void deleteMessageById(long customerContactId);

    public List<CustomerContact> getAllCustomerContact();


    List<CustomerContact> getAllCustomerMessage(Integer pageNumber);

    void save(CustomerContact customerContact);

    void delete(long customerContactId);

    List<CustomerContact> findAll();

}
