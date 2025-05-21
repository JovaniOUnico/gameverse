
package com.generation.gameverse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gameverse.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findAllByNomeContainingIgnoreCase(String nome);
}