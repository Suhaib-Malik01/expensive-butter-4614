package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer productID;
	
	private String name;
	
	private String photoPath;
	
	private Double price;
	
	private String description;
	
	private Boolean available;
	
	@ManyToOne
	private Category category;

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", photoPath=" + photoPath + ", price=" + price
				+ ", description=" + description + ", available=" + available + "]";
	}
	
	
	
	
}