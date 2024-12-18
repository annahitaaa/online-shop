package org.example.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.data.entities.Customer;
import org.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
@AllArgsConstructor
@Data
public class CustomerRegisterController {

    private CustomerService customerService;

    @GetMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") Customer customer){
        return "registerCustomer";
    }

    @PostMapping("/register")
    public String save(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "registerCustomer";
        }
        customerService.addCustomer(customer);
      return "registerCustomerSuccess";
    }

}
