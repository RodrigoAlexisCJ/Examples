package com.example.rest.example.demo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.rest.example.model.User;
import com.example.rest.example.model.UserRepository;

@Component
public class DemoData {

	@Autowired
	private UserRepository repository;
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		if (repository.count() == 0) {
			System.out.println("Saving demo data..........");
			repository.saveAll(Stream.of(
					new User("pashu", "calderon", "pashuCalderon@gmail.com"),
	                new User("cuquito", "calderon", "cuquitoCalderon@gmail.com"),
	                new User("mobile", "electronics", "white"),
	                new User("T-Shirt", "clothes", "black")
            ).
            collect(Collectors.toList()));
//			repository.save(new Order("mobile", "electronics", "white", 20000));
		}
	}
}