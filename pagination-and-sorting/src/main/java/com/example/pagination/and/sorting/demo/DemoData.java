package com.example.pagination.and.sorting.demo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.pagination.and.sorting.entity.Product;
import com.example.pagination.and.sorting.repository.ProductRepository;

@Component
public class DemoData {

	@Autowired
	private ProductRepository repository;
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		System.out.println("Saving demo data..........");
		if (repository.count() == 0) {
	        List<Product> products = IntStream.rangeClosed(1, 200)
            .mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new Random().nextInt(50000)))
            .collect(Collectors.toList());
	        repository.saveAll(products);
//			repository.saveAll(Stream.of(
//					new Product("Television", 2, 10000),
//					new Product("Mobile", 10, 8000),
//	                new Product("T-Shirt", 30, 150)
//            ).
//            collect(Collectors.toList()));
		}
	}
}