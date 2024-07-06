package org.bdebeach.bdebeach.repository;

import java.util.Optional;

import org.bdebeach.bdebeach.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByCorreo(String correo);
	
}//interface UsuarioRepo


