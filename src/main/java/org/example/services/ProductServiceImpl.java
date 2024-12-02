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
    public void save(ProductDTO dto) {

        Product product = mapper.map(dto, Product.class);
        productDAO.save(product);

    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productDAO.findAll();
        List<ProductDTO> productDTOList = products.stream()
                .map(product -> mapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
        return productDTOList;
    }

    @Override
    public void delete(ProductDTO.DELETE dto) {
        log.info("");
        productDAO.delete(dto.getId());

    }


}
