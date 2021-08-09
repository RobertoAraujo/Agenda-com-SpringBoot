package com.contatos.Contatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.contatos.Contatos.model.Produto;
import com.contatos.Contatos.repository.Produtos;

@Controller
public class CadastroController {
	@Autowired
	private Produtos produt;
	
	// cadastra e salva no banco
	@RequestMapping(path = "/cadastro",  method = RequestMethod.GET)
	public ModelAndView cadastroGet(Produto produto){			
		return new ModelAndView("cadastro");
	}
	
	@RequestMapping(path = "/cadastro",  method = RequestMethod.POST)
	public ModelAndView CadastroPost(Produto produto){			
		produt.save(produto);
		
		return new ModelAndView("cadastro");
	}
	
	
}
