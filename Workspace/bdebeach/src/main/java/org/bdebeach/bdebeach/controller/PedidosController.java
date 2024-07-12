package org.bdebeach.bdebeach.controller;

import java.util.List;

import org.bdebeach.bdebeach.model.Pedido;
import org.bdebeach.bdebeach.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
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
//@CrossOrigin(origins="http://localhost:5502")
@RequestMapping(path="/api/pedidos/")
public class PedidosController {
	
	private final PedidoService pedidoService;
	
	@Autowired
	public PedidosController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}//constructor
	
	@GetMapping
	public List<Pedido> getPedidos() {
		return pedidoService.getAllPedidos();
	}//getPedidos
	
	@GetMapping(path="{prodId}") // http://localhost:8080/api/pedidos/1
	public Pedido getPedido(@PathVariable("prodId") Long id) {
		return pedidoService.getPedido(id);
	}//getPedido
	
	@DeleteMapping(path="{prodId}") // http://localhost:8080/api/pedidos/1
	public Pedido deletePedido(@PathVariable("prodId") Long id) {
		return pedidoService.deletePedido(id);
	}//deletePedido
	
	@PostMapping // // http://localhost:8080/api/pedidos/
	public Pedido addPedido(@RequestBody Pedido pedido) {
		return pedidoService.addPedido(pedido);
	}//addPedido
	
	@PutMapping(path="{prodId}") // http://localhost:8080/api/pedido/1
	public Pedido updatePedido(@PathVariable("prodId") Long id, 
			@RequestParam(required=false) Long id_user,
			@RequestParam(required=false) String fecha,
			@RequestParam(required=false) String status,
			@RequestParam(required=false) String mPago,
			@RequestParam(required=false) Double total) {
		return pedidoService.updatePedido(id, id_user, fecha, status, mPago, total);
	}//updatePedido
	
}//PedidosController
