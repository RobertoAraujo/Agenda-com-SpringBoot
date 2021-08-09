package com.contatos.Contatos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
//	 @RequestMapping(value = "/", method = RequestMethod.GET)
//	 public String getPostNew() {
//	    return "/index";
//	 }
	 
	@GetMapping("/index")
	public String index() {
	   return "/index";
	}
}
