package com.example.pagination.and.sorting.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

	private int id;
	@NotBlank(message = "Product shouldn´t be empty")
	private String name;
	@Min(1)
	private int quantity;
	@NotNull
	private long price;
	
	public ProductRequest(@NotBlank(message = "Product shouldn´t be empty") String name, @NotNull int quantity,
			@NotNull long price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
}
