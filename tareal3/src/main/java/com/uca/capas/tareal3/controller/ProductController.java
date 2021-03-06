package com.uca.capas.tareal3.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		return mav;
				
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) { 
		ModelAndView mav = new ModelAndView();	
		
		if( product.getCantidad() > 1 && product.getCantidad() <= productos.get(product.getId()).getCantidad()) {
			String buyStr = "El producto " + productos.get(product.getId()).getNombre() +" se adquirió.";
			mav.addObject("success", buyStr);
			mav.setViewName("compra");
	
		}else {
			String errorStr = "El producto " + productos.get(product.getId()).getNombre() +" no se puede adquirir."; 
			mav.addObject("fail", errorStr);
			mav.setViewName("error");
	
		}
		
		return mav;
	}
	
}
