package com.web.aluminio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.aluminio.model.Trabajo;
import com.web.aluminio.services.TrabajoServices;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/trabajo")
public class TrabajoController {
	
	@Autowired
	private TrabajoServices trabRepo ;
	
	
	@GetMapping
	public @ResponseBody Iterable<Trabajo> getAllTrabajos() {
		return trabRepo.findAllTrabajos();
	}
	  
	@PostMapping("/admin/add")
	public Trabajo createTrabajo(@RequestBody Trabajo trab) {
		if (trab.getId() == 0 ) trab.setId(null);
		return trabRepo.save(trab);
	}
	
	@DeleteMapping("/admin/delete/{id}")
	public boolean borrarTrabajo(@PathVariable(value = "id")  Long id) {
		return trabRepo.bajaFisica(id);
	}
	
	@GetMapping("/{id}")
	public Trabajo getCategoriaById(@PathVariable(value = "id") Long catId) {
		Trabajo categ = trabRepo.getByIdTrabajo(catId);
		return categ;
	}

}
