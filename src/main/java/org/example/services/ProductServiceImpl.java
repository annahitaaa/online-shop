package org.example.services;

import lombok.extern.log4j.Log4j;
import org.example.data.ProductDAO;
import org.example.data.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


@Transactional
@Service
@Log4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ModelMapper mapper;

    @Override
    public void save(Product product) {
//        Product product = mapper.map(dto, Product.class);
        productDAO.save(product);
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = productDAO.findAll();
        return products;
    }

    @Override
    public void delete(long productId) {
        log.info("");
        productDAO.delete(productId);
    }

    @Override
    public Product find(long productId) {
        return productDAO.find(productId);
    }

    @Override
    public List<Product> getAllProductsByBrandOrModelOrCategory(String searchTerm) {
        return null;
    }

    @Override
    public List<Product> getAllProductByCategory(int pageNumber, String productCategory) {
        return productDAO.getAllProductByCategory(pageNumber, productCategory);
    }

    @Override
    public List<Product> getAllProductByBrandOrModel(int pageNumber, String searchTerm, String productCategory) {
        return null;
    }

    @Override
    public List<Product> getAllProductByBrandOrModelOrCategory(Integer pageNumber, String searchTerm) {
        return null;
    }

    @Override
    public void update(Product product) throws SQLException {
        productDAO.update(product);
    }
}
