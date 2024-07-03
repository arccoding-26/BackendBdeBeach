package org.bdebeach.bdebeach.controller;

import org.bdebeach.bdebeach.model.Detalles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/detalles/")
public class DetallesPedidoController {

	private final DetallesService detallesService;

	@Autowired	
	public DetallesPedidoController(DetallesService detallesService) {
		this.detallesService=detallesService;
	}// contrusctor

	@GetMapping
	public List<Detalles> getDetalles() {
		return detallesService.getAllDetalles();
	}

	@GetMapping(path = "{detId}")
	public Detalles getDetalle(@PathVariable("detId") Long id) {
		return detallesService.getDetalles(id);
	}

	@DeleteMapping(path = "{detId}")
	public Detalles deleteDetalle(@PathVariable("detId") Long id) {
		return detallesService.deleteDetalles(id);
	}

	@PostMapping
	public Detalles addDetalles(@RequestBody Detalles detalles) {
		return detallesService.addDetalles(detalles);
	}// addProduct

	@PutMapping(path = "{detId}")
	public Detalles updateDetalles(@PathVariable("detId") Long id,
			@RequestParam(required = false) Long id_user,
			@RequestParam(required = false) Long id_pedido,
			@RequestParam(required = false) String color,
			@RequestParam(required = false) String talla, 
			@RequestParam(required = false) int cantidad) {
		return detallesService.updateDetalles(id_user, id_pedido, id, color, talla, cantidad);
	}// updateProduct
}
