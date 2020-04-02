package com.webupps.controller;

import java.util.Collections;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webupps.model.Product;
import com.webupps.repositories.ProductRespository;


@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductRespository repository;
	
	@PostMapping("/add")
	public @ResponseBody Map<String,Boolean> addNewProduct(@Valid @RequestBody Product obj) {		
		repository.save(obj);		
		
		return Collections.singletonMap("succeed",true);
		
	}
	@PostMapping("/update")
	public @ResponseBody Map<String,Boolean> updateProduct(@Valid @RequestBody Product obj) {
		repository.save(obj);		
		
		return Collections.singletonMap("succeed",true);
				
	}
	@GetMapping("/get/{productid}")
	public @ResponseBody Product getProduct(@PathVariable("productid") Integer id) {		
		
		return repository.findById(id).get();	
		
	}
	@GetMapping("/getall")
	public @ResponseBody Iterable<Product> getAllProduct() {		
		
		return repository.findAll();
		
	}
	@GetMapping("/del/{productid}")
	public @ResponseBody Map<String,Boolean> deleteProduct(@PathVariable("productid") Integer id) {		
		repository.delete(repository.findById(id).get());
		
		
		return Collections.singletonMap("succeed",true);
		
	}
}

