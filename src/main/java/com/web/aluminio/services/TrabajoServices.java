package com.web.aluminio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.aluminio.model.Trabajo;
import com.web.aluminio.repositories.TrabajoRepository;
@Service
public class TrabajoServices {
	
	@Autowired
	private TrabajoRepository trabRepo ;

	public Iterable<Trabajo> findAllTrabajos() {
		return trabRepo.findAll();
	}

	public Trabajo save(Trabajo cat) {
		return trabRepo.save(cat);
	}

	public Trabajo getByIdTrabajo(Long catId) {
		// TODO Auto-generated method stub
		if (trabRepo.existsById(catId)) 
		return trabRepo.findById(catId).get();
		return null;
	}

	public boolean bajaFisica(Long id) {
		if (trabRepo.existsById(id)) {			
			trabRepo.deleteById(id);
			return true;}
		return false;
	}

}
