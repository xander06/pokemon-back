package com.api.pokemonx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.pokemonx.model.Pok;

@Repository
public interface PokRepository extends JpaRepository<Pok, Long>{  
	List<Pok> findByname(@Param("name")String name);
}
