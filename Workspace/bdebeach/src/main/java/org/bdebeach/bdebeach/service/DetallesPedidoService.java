package org.bdebeach.bdebeach.service;

import java.util.List;
import java.util.Optional;

import org.bdebeach.bdebeach.model.Detalles;
import org.bdebeach.bdebeach.repository.DetallesPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallesPedidoService {
	public final DetallesPedidoRepository detallesPedidoRepository;

	@Autowired
	public DetallesPedidoService(DetallesPedidoRepository detallesPedidoRepository) {
		this.detallesPedidoRepository = detallesPedidoRepository;
	}// constructor

	public List<Detalles> getAllDetalles() {
		return detallesPedidoRepository.findAll();
	}// getAllDetalles

	public Detalles getDetalles(Long id) {
		return detallesPedidoRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("Los detalles del pedido con el id [" + id + "] no existen"));
	}// Detalles

	public Detalles deleteDetalles(Long id) {
		Detalles tmpDet = null;
		if (detallesPedidoRepository.existsById(id)) {
			tmpDet = detallesPedidoRepository.findById(id).get();
			detallesPedidoRepository.deleteById(id);
		} // if
		return tmpDet;
	}// deleteDetalles

	public Detalles addDetalles(Detalles detalles) {
		Optional<Detalles> tmpDet = detallesPedidoRepository.findById(detalles.getId());
		if (tmpDet.isEmpty()) {
			return detallesPedidoRepository.save(detalles);
		} else {
			System.out.println("Los detalles del Id [" + detalles.getId() + "] ya existen");
			return null;
		} // else
	}
//addDetalles
	public Detalles updateDetalles (Long id, Long id_producto, Long id_pedido, String color, String talla, Integer cantidad) {
		Detalles tmpDet = null;
		if (detallesPedidoRepository.existsById(id)) {
			Detalles detalles = detallesPedidoRepository.findById(id).get();
			if (id_producto!=null) detalles.setId_producto(id_producto);
			if (id_pedido!=null) detalles.setId_pedido(id_pedido);
			if (color!=null) detalles.setColor(color);
			if (talla!=null) detalles.setTalla(talla);
			if (cantidad!=null) detalles.setCantidad(cantidad);
			
			detallesPedidoRepository.save(detalles);
			tmpDet=detalles;
			}//if

			return tmpDet;
	}//updateDetalles
}