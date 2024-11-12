package org.example.controllers;

import org.apache.log4j.Logger;
import org.example.models.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    Logger logger = Logger.getLogger(ProductController.class);

    @GetMapping("/show")
    public String show(){
        return "product-show";
    }

    @PostMapping("/save")
    public String save(ProductDTO productDTO){
        logger.debug(productDTO);
         return "redirect:/";
    }
}
