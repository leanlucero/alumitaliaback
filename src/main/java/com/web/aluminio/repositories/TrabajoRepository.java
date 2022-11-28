package com.web.aluminio.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.aluminio.model.Trabajo;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Long>{
	
}
