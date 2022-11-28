package com.web.aluminio.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.aluminio.model.Admin;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/logear")
public class AutenticationController {
	
	@PostMapping("/")
	public Boolean intentarLogear(@RequestBody Admin admin) {
		return (admin.getUsername().equals("chata") && admin.getPassword().equals("bilardo") );
	}	
	
	@GetMapping
	public Boolean getAllCategorias() {
		return true;
	}

}
