package org.example.controllers;


import org.example.data.entities.Cart;
import org.example.data.entities.Customer;
import org.example.data.entities.CustomerOrder;
import org.example.exceptions.CustomError;
import org.example.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class OrderController implements HandlerExceptionResolver {

	
	
	
	@Autowired
	private CartService cartService;
	 
	@RequestMapping("/order/{cartId}")
	public String createOrder(@PathVariable("cartId")long cartId){
	
		CustomerOrder customerOrder=new CustomerOrder();
		
		Cart cart=cartService.getCartById(cartId);
		customerOrder.setCart(cart);
		
		Customer customer=cart.getCustomer();
		customerOrder.setCustomer(customer);
		customerOrder.setBillingAddress(customer.getBillingAddress());
		customerOrder.setShippingAddress(customer.getShippingAddress());
		
		
		
		
		//customerOrderService.addCustomerOrder(customerOrder);
		return "redirect:/checkout?cartId="+cartId;
	}
	
	
	
	
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
										 Exception ex) {
		ModelAndView modelAndView=new ModelAndView();
		CustomError error=new CustomError();
	
		
		error.setMessage("Your request is not valid.Please Enter a valid request.");
		modelAndView.addObject("customError", error);
		modelAndView.setViewName("error_page");
		
		return modelAndView;
	}
}
