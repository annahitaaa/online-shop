package org.example.services;

import org.example.data.entities.Product;
import org.example.models.ProductDTO;

import java.util.List;


public interface ProductService {

    void save(Product product);

    List<ProductDTO> findAll();

    void delete(ProductDTO.DELETE dto);
}
