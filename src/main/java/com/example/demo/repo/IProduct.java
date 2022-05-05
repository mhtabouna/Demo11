package com.example.demo.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Product;

public interface IProduct extends JpaRepository<Product, Long>{

	Page<Product> findByDesgLike(String d, Pageable p);
	List<Product> findByPrixLessThan(double price);
}
