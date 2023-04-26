package com.example.pagination.and.sorting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT_TBL")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Product {
	
	private @Id @GeneratedValue int id;
	@NotBlank(message = "Product shouldn´t be empty")
	private String name;
	@NotNull
	private int quantity;
	@NotNull
	private long price;

	public Product(String name, int quantity, long price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
}
