package org.example.services;

import lombok.extern.log4j.Log4j;
import org.example.data.entities.Product;
import org.example.data.ProductDAO;
import org.example.models.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

        //Product product = mapper.map(dto, Product.class);
        productDAO.save(product);

    }

    @Override
    public List<Product> findAll() {
        List<Product> products = productDAO.findAll();
        return products;
    }

    @Override
    public void delete(ProductDTO.DELETE dto) {
        log.info("");
        productDAO.delete(dto.getId());

    }

    @Override
    public Product find(long productId) {
        Product product = productDAO.find(productId);
        return product;
    }

    @Override
    public List<Product> getAllProductsByBrandOrModelOrCategory(String searchTerm) {
        return null;
    }


}
