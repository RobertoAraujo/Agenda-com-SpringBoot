package com.contatos.Contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.contatos.Contatos.model.Contato;
import com.contatos.Contatos.repository.Contatos;

@Controller
public class ContatoController {

	@Autowired
	private Contatos contat;
	
	@RequestMapping(path = "/contatos", method = RequestMethod.GET)
	public ModelAndView listarContato() {
		List<Contato> lista = contat.findAll(); 
	    ModelAndView modelAndView = new ModelAndView("contatos");
	    modelAndView.addObject("contatos", lista);
	     
	    return modelAndView;
	  }

	@RequestMapping(path = "/contatos-cadastro", method = RequestMethod.GET)
	public ModelAndView cadastroContatoGet(Contato contato) {
		return new ModelAndView("contatos-cadastro");
	}

	@RequestMapping(path = "/contatos-cadastro", method = RequestMethod.POST)
	public ModelAndView CadastroContatoPost(Contato contato) {
		// salva no banco
		contat.save(contato);
		return new ModelAndView("contatos-cadastro");
	}
	
	@PostMapping("/update-conato/{id}")
	public String updateContato(@PathVariable("id") long id, @Validated Contato contato, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        contato.setId(id);
	        return "atualizar-produtos";
	    }
	        
	    contat.save(contato);
	    return "contatos";
	}
	
	@RequestMapping(path = "/contatos/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Contato contato = contat.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Id Não Encotrado:" + id));
		contat.delete(contato);
	    return "redirect:/contatos";
	}
}
