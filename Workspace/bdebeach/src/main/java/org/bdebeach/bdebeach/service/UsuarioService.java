package org.bdebeach.bdebeach.service;

import java.util.List;
import java.util.Optional;

import org.bdebeach.bdebeach.dto.ChangePassword;
import org.bdebeach.bdebeach.model.Usuario;
import org.bdebeach.bdebeach.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	public final UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}//constructor
	
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}//getAllUsuarios

	public Usuario getUsuarios(Long id) {
		return usuarioRepository.findById(id).orElseThrow(
		()-> new IllegalArgumentException("El usuario con el id [" +
				id + "] no existe")
				);
	}//getUsuarios

	public Usuario deleteUsuario(Long id) {
		Usuario tmpUser = null;
		if (usuarioRepository.existsById(id)) {
			tmpUser=usuarioRepository.findById(id).get();
			usuarioRepository.deleteById(id);
		}//if
		return tmpUser;
	}//deleteProduct

	public Usuario addUsuario(Usuario usuario) {
		Optional<Usuario> tmpUsuario=
				usuarioRepository.findByCorreo(usuario.getCorreo());
		if(tmpUsuario.isEmpty()) {
			usuario.setContrasena(encoder.encode(usuario.getContrasena()));
			return usuarioRepository.save(usuario);
		} else {
			System.out.println("El usuario con el email [" +
						usuario.getCorreo()+ "] ya existe");
			return null;
		}//else
	}//addUsuario
	
	public Usuario updateContrasena(Long id, ChangePassword cambiarcontrasena) { 
		Usuario tmpUsuario = null;
		if (usuarioRepository.existsById(id)) {
			tmpUsuario = usuarioRepository.findById(id).get();
			
			//if (cambiarcontrasena.getContrasena().equals(tmpUsuario.getContrasena())) {
			if(encoder.matches(cambiarcontrasena.getContrasena(), tmpUsuario.getContrasena())) {
				tmpUsuario.setContrasena(encoder.encode(cambiarcontrasena.getnContrasena()));
				usuarioRepository.save(tmpUsuario);
			}else {
				System.out.println("updateUsuario - La contraseña del usuario ["+
						id + "] no coincide");
				tmpUsuario=null;
			}//if equals
		
		}//if existById
		return tmpUsuario;
	}//updateContraseña
	
	public Usuario updateUsuario(Long id, String telefono, String callenumero, String colonia, String estado, String CP ) { 
		Usuario tmpUsuario = null;
		if (usuarioRepository.existsById(id)) {
			Usuario usuario = usuarioRepository.findById(id).get();
			if ( telefono != null)
				usuario.setTelefono(telefono);
			if ( callenumero!= null)
				usuario.setCalleNumero(callenumero);
			if (colonia != null)
				usuario.setColonia(colonia);
			if (estado != null)
				usuario.setEstado(estado);
			if (CP != null)
				usuario.setCP(CP);
			tmpUsuario=usuario;
			usuarioRepository.save(usuario);
		}//if existbyId
		return tmpUsuario;
	}//updateUsuario
	public boolean validateUsuario(Usuario usuario) {
		Optional <Usuario> userByCorreo =
				usuarioRepository.findByCorreo(usuario.getCorreo());
		if(userByCorreo.isPresent()) {
			Usuario tmpUsuario = userByCorreo.get();
			if(encoder.matches(usuario.getContrasena(), tmpUsuario.getContrasena())) {
				return true;
			}//if encoder.matches
		}//if isPresent
		return false;
	}//validateUser  
	
}//classUsuarioService
