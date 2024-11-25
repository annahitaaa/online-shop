package org.example.controllers;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.example.models.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product/rest")
@Log4j
public class ProductRestService {



//    Logger logger = Logger.getLogger(ProductController.class);
    List<ProductDTO> list = new ArrayList<ProductDTO>()
    {{
        add(new ProductDTO(110,"glass",1000,"home"));
        add(new ProductDTO(23,"book",2000,"school"));
    }};

    @GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO detailWithPathParam(@PathVariable("id") int id){
        log.debug(id);
        //TODO: get the product and add it to model and the dispatch it to view
        return list.get(0);
    }


}
