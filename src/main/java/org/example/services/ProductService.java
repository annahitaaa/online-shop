package org.example.services;



import org.example.data.entities.Product;

import java.sql.SQLException;
import java.util.List;


public interface ProductService {

    void save(Product dto);

    List<Product> findAll();

    void delete(long productId);

    Product find(long productId);

    List<Product> getAllProductsByBrandOrModelOrCategory(String searchTerm);

    List<Product> getAllProductByCategory(int pageNumber, String productCategory);

    List<Product> getAllProductByBrandOrModel(int pageNumber, String searchTerm, String productCategory);

    List<Product> getAllProductByBrandOrModelOrCategory(Integer pageNumber, String searchTerm);

    void update(Product dto) throws SQLException;
}
