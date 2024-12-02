package org.example.services;

import org.example.models.ProductDTO;

import java.util.List;


public interface ProductService {

    void save(ProductDTO dto);

    List<ProductDTO> findAll();

    void delete(ProductDTO.DELETE dto);
}
