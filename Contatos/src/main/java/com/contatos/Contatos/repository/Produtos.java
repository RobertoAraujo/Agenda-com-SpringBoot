package com.contatos.Contatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.contatos.Contatos.model.Produto;

@Repository
public interface Produtos extends JpaRepository<Produto, Long>{

	//Produto findByProduto(Long id);
	
	@Query(value = "select * from produto where ativo = 1", nativeQuery = true)
	List<Produto> getRows(); 
	
	
}
