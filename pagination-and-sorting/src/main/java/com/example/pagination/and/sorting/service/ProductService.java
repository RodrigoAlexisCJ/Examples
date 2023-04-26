package com.example.pagination.and.sorting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.pagination.and.sorting.dto.ProductRequest;
import com.example.pagination.and.sorting.entity.Product;
import com.example.pagination.and.sorting.exception.ProductNotFoundException;
import com.example.pagination.and.sorting.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
	
	public List<Product> getAllProductsSortedByField(String field) {
		return repository.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public Page<Product> getAllProductsWithPagination(int offset, int pagesize){
		Page<Product> products = repository.findAll(PageRequest.of(offset, pagesize));
		return products;
	}
	
	public Page<Product> getAllProductsWithPaginationAndSort(int offset, int pagesize, String field){
		Page<Product> products = repository.findAll(PageRequest.of(offset, pagesize).withSort(Sort.by(field)));
		return products;
	}
	
	public Product getProductById(int id) {
		Product productFounder = repository.findProductById(id);
		if (productFounder == null) {
			throw new ProductNotFoundException(String.format("Product not found by id: %d", id));
		} else {
			return productFounder;
		}
	}
	
	public Product saveProduct(ProductRequest request) {
		Product productSaved = Product.build(0, request.getName(), request.getQuantity(), request.getPrice());
		return repository.save(productSaved);
	}
}
