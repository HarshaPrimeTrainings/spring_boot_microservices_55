package com.training.productapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	List<Product> productsList = new ArrayList<>();
	
	public ProductController() {
		productsList.add(new Product(1,"ipad", 5));
		productsList.add(new Product(2,"androidtab", 7));
		productsList.add(new Product(3,"watch", 2));
		productsList.add(new Product(4,"Books", 10));
	}
	
	@RequestMapping("/products")
	public ModelAndView getAllProducts() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("productlist",productsList);
		mav.setViewName("product");
		return mav;
	}
	
	@RequestMapping("/add")
	public String addProduct() {
		return "addproduct";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView saveProdcut(@ModelAttribute Product product) {
		productsList.add(product);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productlist",productsList);
		mav.setViewName("product");
		return mav;
	}
	
	
	
	
}
