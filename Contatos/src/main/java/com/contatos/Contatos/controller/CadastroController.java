package com.contatos.Contatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.contatos.Contatos.repository.Produtos;

@RestController
@RequestMapping(path = "/cadastro", method = RequestMethod.GET )
public class CadastroController {

	@Autowired
	private Produtos produtos;

	@GetMapping
	public String cadastro() {
		return "/cadastro";
	}

}
