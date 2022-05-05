package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category {

	@Id
	@GeneratedValue
	long idcat;
	String libelle,description;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Product> products=new ArrayList<>();

	public long getIdcat() {
		return idcat;
	}

	public void setIdcat(long idcat) {
		this.idcat = idcat;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String libelle, String description) {
		super();
		this.libelle = libelle;
		this.description = description;
	}
	
	
}
