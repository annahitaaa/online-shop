package org.example.controllers;

import org.apache.log4j.Logger;
import org.example.models.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    List<ProductDTO> list = new ArrayList<ProductDTO>()
    {{
        add(new ProductDTO(110,"glass",1000,"home"));
        add(new ProductDTO(23,"book",2000,"school"));
    }};

    @Autowired
    Logger logger;

   // Logger logger = Logger.getLogger(ProductController.class);

//    @GetMapping("/show")
//    public String show(ProductDTO productDTO,Model model ){
//        model.addAttribute("productDTO",productDTO);
//
//        return "product-show";
//    }

    @GetMapping("/show")
    public String show(@ModelAttribute("dto") ProductDTO productDTO ){
        return "product-show";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("dto") ProductDTO productDTO, BindingResult result){
        if(result.hasErrors()){
            return "product-show";
        }
        SecureRandom random = new SecureRandom();
        productDTO.setId(random.nextInt(1000));
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
    public String detailWithQueryString(@RequestParam("id") int dummy){
        logger.debug(dummy);
        return "product-detail";
    }
    @GetMapping("/detail/{id}")
    public String detailWithPathParam(@PathVariable("id") int id){
        logger.debug(id);
        //TODO: get the product and add it to model and the dispatch it to view
        return "product-detail";

    }
}
