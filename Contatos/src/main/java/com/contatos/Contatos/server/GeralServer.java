package com.contatos.Contatos.server;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contatos.Contatos.model.Produto;
import com.contatos.Contatos.repository.Produtos;

@Service
@Transactional
public class GeralServer {
	
	@Autowired
	private Produtos produtosrepository;
	
	public List<Produto> listAll() {
        return produtosrepository.findAll();
    }
     
    public void save(Produto produto) {
    	produtosrepository.save(produto);
    }
     
    public Produto get(long id) {
        return produtosrepository.findById(id).get();
    }
     
    public void delete(long id) {
    	produtosrepository.deleteById(id);
    }

}
