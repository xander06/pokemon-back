package com.api.pokemonx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.api.pokemonx.model.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	List<Categoria> findByname(@Param("id")Long id);

}
