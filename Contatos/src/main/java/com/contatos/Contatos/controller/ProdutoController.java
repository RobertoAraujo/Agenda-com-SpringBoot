package com.contatos.Contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.contatos.Contatos.model.Produto;
import com.contatos.Contatos.repository.Produtos;

@Controller
public class ProdutoController {

	@Autowired
	private Produtos produt;
	
    // listar 
	@RequestMapping(path = "/produtos", method = RequestMethod.GET)
	public ModelAndView listarProduto() {
		List<Produto> lista = produt.findAll();
		ModelAndView modelAndView = new ModelAndView("produtos");
		modelAndView.addObject("produtos", lista);
		return modelAndView;
	}
    // chamar requisição de cadastrar
	@RequestMapping(path = "/produto-cadastro", method = RequestMethod.GET)
	public ModelAndView cadastroProdutoGet(Produto produto) {
		return new ModelAndView("produto-cadastro");
	}
	// requisição de editar
	@PostMapping("/update-produto/{id}")
	public String updateProduto(@PathVariable("id") long id, @Validated Produto produto, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        produto.setId(id);
	        return "atualizar-produtos";
	    }
	        
	    produt.save(produto);
	    return "produtos";
	}
	    
	@GetMapping("/produtos/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Produto produto = produt.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Id Não Encotrado:" + id));
		produt.delete(produto);
	    return "redirect:/produtos";
	}

	// salva no banco
	@RequestMapping(path = "/produto-cadastro", method = RequestMethod.POST)
	public ModelAndView CadastroProdutoPost(Produto produto) {
		produt.save(produto);
		return new ModelAndView("produto-cadastro");
	}
}
