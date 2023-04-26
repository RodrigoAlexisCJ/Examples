package com.example.pagination.and.sorting.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pagination.and.sorting.dto.ProductRequest;
import com.example.pagination.and.sorting.entity.Product;
import com.example.pagination.and.sorting.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.ok(service.getAllProducts());
	}
	
	@GetMapping(value = "/{field}")
	public ResponseEntity<List<Product>> getAllProductWithSort(@PathVariable String field) {
		return ResponseEntity.ok(service.getAllProductsSortedByField(field));
	}
	
	@GetMapping(value = "/pagination/offset/{offset}/pagesize/{pagesize}")
	public ResponseEntity<Page<Product>> getAllProductWithPage(@PathVariable int offset, @PathVariable int pagesize) {
		return ResponseEntity.ok(service.getAllProductsWithPagination(offset, pagesize));
	}
	
	@GetMapping(value = "/pagination/offset/{offset}/pagesize/{pagesize}/field/{field}")
	public ResponseEntity<Page<Product>> getAllProductWithPageAndSort(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field) {
		return ResponseEntity.ok(service.getAllProductsWithPaginationAndSort(offset, pagesize, field));
	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id) {
		return ResponseEntity.ok(service.getProductById(id));
	}
	
	@PostMapping(value = "/signup")
	public ResponseEntity<Product> saveUser(@Valid @RequestBody ProductRequest request) {
		return new ResponseEntity<>(service.saveProduct(request),HttpStatus.CREATED);
	}
	
}
