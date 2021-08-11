package com.contatos.Contatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.contatos.Contatos.model.Contato;

@Repository
public interface Contatos extends JpaRepository<Contato, Long>{

	//Contato findContatoById(Long id);
	
	@Query(value = "select * from contato where ativo = 1", nativeQuery = true)
	List<Contato> findAllAtivas(); 
}
