package com.web.aluminio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.aluminio.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long >{
	
	public Categoria getByNombre(@Param("nombre")String nombre) ;
	

}
