package com.contatos.Contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contatos.Contatos.model.Produto;

@Repository
public interface Produtos extends JpaRepository<Produto, Long>{

}
