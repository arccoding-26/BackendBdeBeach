package org.bdebeach.bdebeach.repository;

import java.util.Optional;

import org.bdebeach.bdebeach.model.Detalles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesPedidoRepository extends JpaRepository<Detalles,Long>{
	Optional<Detalles>findById(String id); 
	}
