package org.example.services;

import org.example.data.entities.Product;
import org.example.models.ProductDTO;

import java.util.List;


public interface ProductService {

    void save(Product product);

    List<Product> findAll();

    void delete(ProductDTO.DELETE dto);

    Product find(long productId);

    List<Product> getAllProductsByBrandOrModelOrCategory(String searchTerm);
}
