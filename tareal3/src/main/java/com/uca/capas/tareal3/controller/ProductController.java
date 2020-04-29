package com.uca.capas.tareal3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tareal3.domain.Product;

@Controller
public class ProductController {
	
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0, "God Of War", 15));
		productos.add(new Product(1, "Uncharted 4", 5));
		productos.add(new Product(2, "Grand Theft Auto V", 30));
		productos.add(new Product(3, "Dark Souls III", 16));
		productos.add(new Product(4, "The Last of Us", 20));
		
		mav.setViewName("select");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		return mav;
				
	}
	
	@PostMapping("/validar")
	@ResponseBody
	public String validar(Product product) {
		return productos.get(product.getId()).getNombre() + "\n" + productos.get(product.getId()).getCantidad() ;
	}
		
	

}
