
package com.contatos.Contatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.contatos.Contatos.model.Contato;
import com.contatos.Contatos.model.Produto;
import com.contatos.Contatos.repository.Contatos;
import com.contatos.Contatos.repository.Produtos;

@Controller
public class CadastroController {
	@Autowired
	private Produtos produt;
	
	// cadastra e salva no banco
	@RequestMapping(path = "/cadastro",  method = RequestMethod.GET)
	public ModelAndView cadastroProdutoGet(Produto produto){			
		return new ModelAndView("cadastro");
	}
	
	@RequestMapping(path = "/cadastro",  method = RequestMethod.POST)
	public ModelAndView CadastroProdutoPost(Produto produto){			
		produt.save(produto);
		
		return new ModelAndView("cadastro");
	}
	
	@Autowired
	private Contatos contat;
	
	// cadastra e salva no banco
		@RequestMapping(path = "/contato-cadastro",  method = RequestMethod.GET)
		public ModelAndView cadastroContatoGet(Contato contato){			
			return new ModelAndView("contato-cadastro");
		}
		
		@RequestMapping(path = "/contato-cadastro",  method = RequestMethod.POST)
		public ModelAndView CadastroContatoPost(Contato contato){			
			contat.save(contato);
			
			return new ModelAndView("contato-cadastro");
		}
	
	
}

