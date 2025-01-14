package org.example.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.models.ProductDTO;
import org.example.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
@Log4j
@AllArgsConstructor
public class ProductController {

    ProductService productService;



}
