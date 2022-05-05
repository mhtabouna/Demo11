package com.example.demo.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.repo.ICategory;

@RestController
public class RestCategory {
	@Autowired
	ICategory crepo;
	
	@PostMapping(path = "/categories")
	public Category add(@RequestBody Category c)
	{
		c=crepo.save(c);
		return c;
		
	}
	
	@GetMapping(path = "/categories/{id}")
	public ResponseEntity<Category> findcat(@PathVariable long id)
	{
		Optional<Category> o = crepo.findById(id);
		if(o.isPresent())
			return new ResponseEntity<>(o.get(),HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@GetMapping(path = "/categories")
	public Page<Category> allcat(@RequestParam(name = "page") int page,@RequestParam(name = "size") int size)
	{
		Pageable p=PageRequest.of(page, size);
		return crepo.findAll(p);
	}
}
