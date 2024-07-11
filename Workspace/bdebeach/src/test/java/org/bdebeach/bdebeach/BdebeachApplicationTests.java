/*package org.bdebeach.bdebeach;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.bdebeach.bdebeach.model.Producto;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class BdebeachApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Se prueba el GET del endpoint htpp://localhost:8088/api/productos/1")
	void pruebaGET() throws Exception {
		this.mockMvc.perform(get("/api/productos/2") )
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Top Bora Bora"))
				);
		this.mockMvc.perform(get("/api/productos/5") )
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Conjunto Mikonos"))
				);
	}//pruebaGET
	
	@Test
	@DisplayName("Se prueba el DELETE del endpoint htpp://localhost:8088/api/productos/1")
	@Disabled("Probado una vez, deshabilitado porque ya no existe el producto id 1")
	void pruebaDELETE() throws Exception {
		this.mockMvc.perform(delete("/api/productos/1")
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Top Mykonos"))
				);
	}//pruebaDELETE
	
	@Test
	@DisplayName("Se prueba crear un producto nuevo (POST)")
	@Disabled("Se creó el producto Top Grecia")
	void pruebaPOST() throws Exception {
		Producto p = new Producto();
		p.setNombre("Top Grecia");
		p.setDescripcion("Top ajustable");
		p.setImg("515ftw-2.jpg");
		p.setPrecio(150.95);
		p.setColores("rosa");
		p.setTallas("S");
		
		this.mockMvc.perform(post("/api/productos/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p) )

				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Top Grecia"))
				);
	}//pruebaPOST
	
	@Test
	@DisplayName("Se prueba modificar un producto id 4")
	void pruebaPUT() throws Exception {
		this.mockMvc.perform(put("/api/productos/4")
				.queryParam("precio", "59.95")
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("59.95"))
				);
	}//pruebaPUT
	
	
	
	// Aquí inician las PU para Usuarios
	@Test
	@DisplayName("Se prueba el GET del endpoint htpp://localhost:8088/api/usuarios/2")
	void pruebaGET1() throws Exception {
		this.mockMvc.perform(get("/api/usuarios/2") )
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("DayaanM"))
				);
		this.mockMvc.perform(get("/api/usuarios/5") )
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Asael"))
				);
	}//pruebaGET
	
	@Test
	@DisplayName("Se prueba el DELETE del endpoint htpp://localhost:8088/api/usuarios/3")
	@Disabled("Probado una vez, deshabilitado porque ya no existe el usuario con id 3")
	void pruebaDELETE1() throws Exception {
		this.mockMvc.perform(delete("/api/usuarios/3")
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Sofia"))
				);
	}//pruebaDELETE
	 
	@Test
	@DisplayName("Se prueba crear un usuario nuevo (POST)")
	// @Disabled("Se creó el usuario Juan Valencia")
	void pruebaPOST1() throws Exception {
		Usuario u = new Usuario();
		u.setNombre("Juan");
		u.setApellido("Valencia");
		u.setCorreo("juanvale@gmail.com");
		u.setContrasena("Pa$$W0rd");
		u.setTelefono("5511223344");
		u.setCalleNumero("Valencia 45");
		u.setColonia("Centro");
		u.setEstado("CDMX");
		u.setCP("04650");
		
		this.mockMvc.perform(post("/api/usuarios/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(u) )

				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Juan"))
				);
	}//pruebaPOST
	
	
	@Test
	@DisplayName("Se prueba modificar un usuario id 4")
	void pruebaPUT1() throws Exception {
		this.mockMvc.perform(put("/api/usuarios/4")
				.queryParam("nombre", "Are")
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Are"))
				);
	}//pruebaPUT
	
	private static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
	 } // asJsonString

}
*/