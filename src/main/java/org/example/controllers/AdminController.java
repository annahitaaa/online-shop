package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.data.entities.Product;
import org.example.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    ProductService productService;

    @RequestMapping
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/productManagement/{pageNumber}")
    public String productManagement(@PathVariable Integer pageNumber, Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "productInventory";
    }

    @RequestMapping("productManagement/search/{pageNumber}")
    public String productManagementSearch(@PathVariable Integer pageNumber, Model model,
                                          @RequestParam("searchTerm") String searchTerm){
        List<Product> products = productService.getAllProductsByBrandOrModelOrCategory(searchTerm);
       //TODO: fix the getALl Method
        model.addAttribute("products", products);
        return "productInventory";
    }

}
