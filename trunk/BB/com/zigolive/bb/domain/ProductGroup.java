package com.zigolive.bb.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProductGroup {
	private long id;
	private String imagesDir;
	private List<Product> products;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	public String getImagesDir() {
		return imagesDir;
	}
	public void setImagesDir(String imagesDir) {
		this.imagesDir = imagesDir;
	}
	@OneToMany
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
