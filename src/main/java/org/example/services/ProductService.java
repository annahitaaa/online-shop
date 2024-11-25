package org.example.services;

import org.example.data.entities.ProductDAO;
import org.example.models.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    void save(ProductDTO dto);

    List<ProductDTO> findAll();

    void delete(ProductDTO.DELETE dto);
}
