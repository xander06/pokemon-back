package com.api.pokemonx.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pokemonx.repository.PokRepository;
import com.api.pokemonx.model.Pok;

@RestController
@RequestMapping("/api")
public class PokController {
	@Autowired
	private PokRepository repository;
	
	
	@GetMapping("/pokemon")
	public List<Pok> allPoks(){
		return repository.findAll();
	}
	@GetMapping("/buscarpokemon/{name}")
	public List<Pok> findByNamePoks(@PathVariable("name") String name) {
		return repository.findByname(name); 
	}
	
}