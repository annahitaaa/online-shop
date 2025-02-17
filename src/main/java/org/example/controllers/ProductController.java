package org.example.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.data.entities.Product;
import org.example.exceptions.CustomError;
import org.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/product")
@Log4j
@AllArgsConstructor
    public class ProductController  implements HandlerExceptionResolver {


        @Autowired
        private ProductService productService;

        @ResponseBody
        @GetMapping(value = "/getImage/{productId}", produces = "image/jpeg")
        public byte[] getProductImage(@PathVariable("productId") long productId) {
            Product product = productService.find(productId);
            return product.getImg();
        }

        @RequestMapping("/productList/{productCategory}/{pageNumber}")
        public String getProductByCategory(@PathVariable("pageNumber") int pageNumber, @PathVariable("productCategory") String productCategory, Model model) {

            List<Product> products;
            if (productCategory.equalsIgnoreCase("all"))
                products = productService.findAll();
            else
                products = productService.getAllProductByCategory(pageNumber, productCategory);


            if (products.size() == 0) {
                model.addAttribute("msg", "No product to show");
            }

            model.addAttribute("products", products);
            model.addAttribute("productCategory", productCategory);
            model.addAttribute("totalPages", 1);
            model.addAttribute("currentPageNumber", 1);
            model.addAttribute("beginIndex", 1);
            model.addAttribute("endIndex", 1);


            return "productList";
        }


        @RequestMapping(value = "/productList/{productCategory}/{pageNumber}", method = RequestMethod.POST)
        public String getProductBySearch(@RequestParam("searchTerm") String searchTerm, @PathVariable("pageNumber") int pageNumber, @PathVariable("productCategory") String productCategory, Model model) {


            List<Product> products = productService.getAllProductByBrandOrModel(pageNumber, searchTerm, productCategory);


            if (products.size() == 0) {
                model.addAttribute("msg", "No product to show");
            }


            model.addAttribute("products", products);
            model.addAttribute("productCategory", productCategory);
            model.addAttribute("totalPages", 1);
            model.addAttribute("currentPageNumber", 1);
            model.addAttribute("beginIndex", 1);
            model.addAttribute("endIndex", 1);


            return "productList";
        }


        @RequestMapping("/productList")
        public String getAllProduct(Model model) {

            List<Product> products = productService.findAll();
            model.addAttribute("products", products);


            return "productList";
        }


        @RequestMapping("/viewProduct/{productId}")
        public String ProductDetailPage(@PathVariable("productId") long productId, Model model) {

            Product product = productService.find(productId);


            model.addAttribute("product", product);
            model.addAttribute("search", "search");
            return "productDetail";
        }


        public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                             Exception ex) {
            ModelAndView modelAndView = new ModelAndView();
            CustomError error = new CustomError();


            error.setMessage("Your request is not valid.Please Enter a valid request.");
            modelAndView.addObject("customError", error);
            modelAndView.setViewName("error_page");

            return modelAndView;
        }
    }