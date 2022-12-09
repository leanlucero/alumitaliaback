package com.web.aluminio.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.aluminio.model.Categoria;
import com.web.aluminio.model.Trabajo;
import com.web.aluminio.services.CategoriaServices;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaServices catServices ;
	
	@GetMapping
	
	public @ResponseBody Iterable<Categoria> getAllCategorias() {
		return catServices.findAllCategorias();
	}
	  
	@PostMapping("/admin/add")
	public Categoria createCategoria(@RequestBody Categoria cat) {
		if (cat.getId() == 0 ) cat.setId(null);
		return catServices.save(cat);
	}
	
	@DeleteMapping("/admin/delete/{id}")
	public boolean borrarCategoria(@PathVariable(value = "id")  Long id) {
		return catServices.bajaFisica(id);
	}
	
	@GetMapping("/{id}")
	public Categoria getCategoriaById(@PathVariable(value = "id") Long catId) {
		Categoria categ = catServices.getByIdCategoria(catId);
		return categ;
	}
	
	@GetMapping("/trabajos/{id}")
	public @ResponseBody Iterable<Trabajo> getTrabajosCategoriaById(@PathVariable(value = "id") Long catId) {
		Categoria categ = catServices.getByIdCategoria(catId);
		return categ.getTrabajos();
	}
	
	@GetMapping("/name/{nombre}")
	public Categoria getByNombre(@PathVariable(value = "nombre") String nombre) {
		Categoria categ = catServices.getByNombre(nombre);
			return categ;
	}

}
