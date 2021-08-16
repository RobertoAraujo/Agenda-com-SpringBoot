package com.contatos.Contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contatos.Contatos.model.Contato;

@Repository
public interface Contatos extends JpaRepository<Contato, Long>{


}
