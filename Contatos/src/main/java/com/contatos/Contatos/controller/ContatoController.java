package com.contatos.Contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.contatos.Contatos.model.Contato;
import com.contatos.Contatos.repository.Contatos;

@RestController
@RequestMapping(path = "/contatos")
public class ContatoController {

	@Autowired
	private Contatos contato;
	
	// usa modelandview poara lista os contatos
	  @GetMapping
	  public ModelAndView listar() {
		List<Contato> lista = contato.findAll();
	     
	    ModelAndView modelAndView = new ModelAndView("contatos");
	    modelAndView.addObject("contatos", lista);
	     
	    return modelAndView;
	  }
}
