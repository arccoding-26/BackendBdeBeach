package org.bdebeach.bdebeach.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.bdebeach.bdebeach.config.JwtFilter;
import org.bdebeach.bdebeach.dto.Token;
import org.bdebeach.bdebeach.model.Usuario;
import org.bdebeach.bdebeach.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
//@CrossOrigin(origins="http://localhost:5502")
@RequestMapping(path="/api/login/")
public class LoginController {
	private final UsuarioService usuarioService;
	@Autowired
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	@PostMapping
	public Token LoginUser(@RequestBody Usuario usuario) throws ServletException {
	if(usuarioService.validateUsuario(usuario)) {
	System.out.println("usuario válido" + usuario.getCorreo());
	return new Token(generateToken(usuario.getCorreo()));
	} //if validateUser
	throw new ServletException("Nombre de usuario o contraseña incorrectos [" + usuario.getCorreo()+ "]");
	}//LogingUser

	private String generateToken(String username) {
	Calendar calendar = Calendar.getInstance();//Fecha hora actual
	calendar.add(Calendar.HOUR, 10); // Pruebas
	//calendar.add(Calendar.MINUTE, 30);// Producción
	return Jwts.builder().setSubject(username).claim("role", "user")
	.setIssuedAt(new Date())
	.setExpiration(calendar.getTime())
	.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
	.compact();
	}//generateToken
}
