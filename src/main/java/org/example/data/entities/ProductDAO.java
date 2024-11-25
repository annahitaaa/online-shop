package org.example.data.entities;


import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductDAO{

    void save(Product product);

    List<Product> findAll();

    void delete(int id);
}
