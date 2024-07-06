package org.bdebeach.bdebeach.repository;

import org.bdebeach.bdebeach.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}
