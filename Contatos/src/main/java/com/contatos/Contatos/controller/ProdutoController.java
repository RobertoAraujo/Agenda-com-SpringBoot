package com.contatos.Contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.contatos.Contatos.model.Produto;
import com.contatos.Contatos.repository.Produtos;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

	@Autowired
	private Produtos produto;
	
	@GetMapping
	  public ModelAndView listar() {
		List<Produto> lista = produto.findAll();
	     
	    ModelAndView modelAndView = new ModelAndView("produtos");
	    modelAndView.addObject("produtos", lista);
	     
	    return modelAndView;
	  }
}
