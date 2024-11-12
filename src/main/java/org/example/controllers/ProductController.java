package org.example.controllers;

import org.apache.log4j.Logger;
import org.example.models.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    List<ProductDTO> list = new ArrayList<>();

    Logger logger = Logger.getLogger(ProductController.class);

    @GetMapping("/show")
    public String show(){
        return "product-show";
    }

    @PostMapping("/save")
    public String save(ProductDTO productDTO){
        list.add(productDTO);
        logger.debug(productDTO);
        //TODO: must persist dto into database
         return "redirect:/";
    }

    @GetMapping("/get-all")
    public String getAll(Model model){
        model.addAttribute("list", list);
        return "product-list";

    }

    @GetMapping("/detail")
    public String detail(){
        return "product-detail";
    }
}
