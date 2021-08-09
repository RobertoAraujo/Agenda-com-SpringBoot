package com.contatos.Contatos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "/")
public class IndexController {
	
	 @RequestMapping(value = "/#", method = RequestMethod.GET)
	 public String getPostNew() {
	    return "/index";
	 }
	 
//	@GetMapping
//	public String index() {	
//	   return "/#";
//	}
}
