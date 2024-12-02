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

    @GetMapping("/show")
    public String show(@ModelAttribute("dto") ProductDTO productDTO ){
        return "product-show";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("dto") ProductDTO.CREATE productDTO, BindingResult result){

        if(result.hasErrors()){
            return "product-show";
        }

        productService.save(productDTO);
         return "redirect:/";
    }

    @GetMapping("/get-all")
    public ModelAndView getAll(ModelAndView modelAndView){
        modelAndView.setViewName("product-list");
        List<ProductDTO> productDTOList =  productService.findAll();
        modelAndView.addObject("list", productDTOList);
        return modelAndView;

    }

    @GetMapping("/detail")
    public String detailWithQueryString(@RequestParam("id") int dummy){
        log.debug(dummy);
        return "product-detail";
    }
    @GetMapping("/detail/{id}")
    public String detailWithPathParam(@PathVariable("id") int id){
        log .debug(id);
        //TODO: get the product and add it to model and the dispatch it to view
        return "product-detail";

    }

    @GetMapping("/delete")
    public String delete(ProductDTO.DELETE dto){

        productService.delete(dto);
        return "redirect:/product/get-all";

    }

}
