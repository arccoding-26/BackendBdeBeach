package org.bdebeach.bdebeach.controller;

import java.util.List;

import org.bdebeach.bdebeach.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/usuario/")
public class UsuarioController {
	private final UsuarioService usuarioService;
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService= usuarioService;
	}//constructor
	
		@GetMapping
		public List<Usuario> getUsers() {
			return usuarioService.getAllUsers();
		}
		
		@GetMapping(path="{userId}") // http://localhost:8080/api/usuarios/1
		public Usuario getUsuario(@PathVariable("userId") Long id) {
			return usuarioService.getUser(id);
		}
		
		@DeleteMapping(path="{userId}") // http://localhost:8080/api/usuarios/1
		public Usuario deleteUser(@PathVariable("userId") Long id) {
			return usuarioService.deleteUser(id);
		}
		
		@PostMapping      // http://localhost:8080/api/usuarios/
		public Usuario addUsuario(@RequestBody Usuario usuario) {
			return usuarioService.addUser(usuario);
		}
		
		@PutMapping(path="{userId}") // http://localhost:8080/api/usuarios/1
		public Usuario updateUsuario(@RequestBody CambiarContrasena cambiarcontrasena,
				@PathVariable("userId") Long id) {
			return usuarioService.updateUser(id, cambiarcontrasena);
		}
}//UsuarioController
