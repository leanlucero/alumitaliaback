package com.web.aluminio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.aluminio.model.Categoria;
import com.web.aluminio.repositories.CategoriaRepository;

@Service
public class CategoriaServices {

	@Autowired
	private CategoriaRepository catRepo ;

	public Categoria getByNombre(String nombre) {
		
		Categoria categoria= catRepo.getByNombre(nombre);
		if (categoria == null) {
			Categoria auxCategoria = new Categoria();
			auxCategoria.setId((long) 0);
			auxCategoria.setNombre("inexistente");
			return auxCategoria;
		}
		return categoria;
	}

	public Iterable<Categoria> findAllCategorias() {
		return catRepo.findAll();
	}

	public Categoria save(Categoria cat) {
		return catRepo.save(cat);
	}

	public Categoria getByIdCategoria(Long catId) {
		// TODO Auto-generated method stub
		if (catRepo.existsById(catId)) 
		return catRepo.findById(catId).get();
		return null;
	}

	public boolean bajaFisica(Long id) {
		// TODO Auto-generated method stub
		if (catRepo.existsById(id)) {			
			catRepo.deleteById(id);
			return true;}
		return false;
	}

}
