package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Category;

public interface ICategory extends JpaRepository<Category, Long>{

}
