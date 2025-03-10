package org.example.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.data.entities.Authorities;
import org.example.data.entities.Cart;
import org.example.data.entities.Customer;
import org.example.data.entities.Users;
import org.example.services.AuthoritiesService;
import org.example.services.CartService;
import org.example.services.CustomerService;
import org.example.services.UsersService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dummy")
@AllArgsConstructor
@Data
public class CustomerRegisterController {

    private CustomerService customerService;
    private UsersService usersService;
    private AuthoritiesService authoritiesService;
    private CartService cartService;

    @GetMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") Customer customer){
        return "registerCustomer";
    }

    @PostMapping("/register")
    public String save(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model,HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "registerCustomer";
        }

        List<Customer> customerList= customerService.getAllCustomers();

        if(customerList == null)
            customerList =new ArrayList<>();

        for(Customer customer2 :customerList){
            if(customer2.getCustomerEmailAddress().equals(customer.getCustomerEmailAddress())){
                model.addAttribute("emailMsg","Email already exists");
                return "registerCustomer";
            }

            if(customer2.getUsername().equals(customer.getUsername())){
                model.addAttribute("usernameMsg","Username already exists");
                return "registerCustomer";
            }

        }
        customer.setEnabled(true);
        customerService.addCustomer(customer);


        Users user = new Users();
        user.setCustomerId(customer.getCustomerId());
        user.setUsername(customer.getUsername());
        user.setPassword(customer.getPassword());
        user.setEnabled(true);

        usersService.addUser(user);

        Authorities authorities = new Authorities();
        authorities.setAuthorityType("ROLE_USER");
        authorities.setUsername(customer.getUsername());


        authoritiesService.addAuthorities(authorities);

        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setGrandTotal(0);

        cartService.addCart(cart);

        customer.setCart(cart);
        customerService.updateCustomer(customer);

        autologin(customer,request);

      return "registerCustomerSuccess";
    }

    private void autologin(Customer customer, HttpServletRequest request){

        String username = customer.getUsername();
        String password = customer.getPassword();

        request.getSession();

        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
