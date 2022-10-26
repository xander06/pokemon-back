package com.api.pokemonx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pokemonx.model.Categoria;
import com.api.pokemonx.repository.CategoriaRepository;

@RestController
@RequestMapping("/")

public class CategoriaController {
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping("/categoria")
	public List<Categoria> allCategoria(){
		return repository.findAll();
	}
	
	@GetMapping("/buscarpocategoria/{name}")
	public List<Categoria> findByNameCategorias(@PathVariable("name") Long name) {
		System.out.println(name);
		return repository.findByname(name);
	}
	
	
}
