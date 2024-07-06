package org.bdebeach.bdebeach.repository;

import java.util.Optional;

import org.bdebeach.bdebeach.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
	@Repository
	public interface ProductoRepository extends JpaRepository<Producto, Long>{
		Optional<Producto> findByNombre(String nombre);
		Optional<Producto> findById(Long id);	
	}//interface ProductoRepository
	
	

