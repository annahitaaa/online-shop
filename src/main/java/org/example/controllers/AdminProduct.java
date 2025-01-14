package org.example.controllers;

import org.example.data.entities.Product;
import org.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminProduct {

    @Autowired
    ProductService productService;

    @GetMapping("/product/addProduct")
    public String showProductPage(@ModelAttribute("product") Product product) {
        product.setProductStatus("Brand New");
        return "addProduct";
    }

   @PostMapping("/product/addProduct")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "addProduct";
        }
        byte[] imgByte = product.getProductImage().getBytes();
        product.setImg(imgByte);
        productService.save(product);
         return "redirect:/admin/productManagement/1";
    }
}
