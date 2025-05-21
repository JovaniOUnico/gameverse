
package com.generation.gameverse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gameverse.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	List<Produto> findByPrecoLessThan(Double valor);
	List<Produto> findByPrecoGreaterThan(Double valor);
}