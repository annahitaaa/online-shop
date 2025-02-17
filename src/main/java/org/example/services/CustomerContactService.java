package org.example.services;

import org.example.data.entities.CustomerContact;

import java.util.List;

public interface CustomerContactService {
    public void addNewMessage(CustomerContact customerContact);

    public void deleteMessageById(long customerContactId);

    public List<CustomerContact> getAllCustomerContact();


    List<CustomerContact> getAllCustomerMessage(Integer pageNumber);

}
