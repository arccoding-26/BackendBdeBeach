package org.bdebeach.bdebeach.service;

import java.util.List;
import java.util.Optional;

import org.bdebeach.bdebeach.model.Pedido;
import org.bdebeach.bdebeach.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PedidoService {
public final PedidoRepository pedidoRepository;
	
	@Autowired
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}//constructor
	
	public List<Pedido> getAllPedidos(){
		return pedidoRepository.findAll();
	}//getAllProducts

	public Pedido getPedido(Long id) {
		return pedidoRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El pedido con el id ["+ id + "] no existe")
				);
	}//getProduct

	public Pedido deletePedido(Long id) {
		Pedido tmpPedido = null;
		if (pedidoRepository.existsById(id)) {
			tmpPedido=pedidoRepository.findById(id).get();
			pedidoRepository.deleteById(id);
		}//if
		return tmpPedido;
	}//deletePedido

	public Pedido addPedido(Pedido pedido) {
		Optional<Pedido> tmpPedido=
					pedidoRepository.findById(pedido.getId());
		if(tmpPedido.isEmpty()) {
			return pedidoRepository.save(pedido);
		}else {
			System.out.println("El pedido con el id [" + pedido.getId() + "] ya existe");
			return null;
		}//else
	}//addPedido
	
	public Pedido updatePedido(Long id,Long id_user, String fecha, String status,String mPago, Double total) {
		Pedido tmpPedido=null;
			if(pedidoRepository.existsById(id)) {
				Pedido pedido=pedidoRepository.findById(id).get();
				if( id_user!=null) pedido.setId_user(id_user);
				if(fecha !=null) pedido.setFecha(fecha);
				if(status !=null) pedido.setStatus(status);
				if(mPago !=null) pedido.setmPago(mPago);
				if(total !=null) pedido.setTotal(total);
				pedidoRepository.save(pedido);
				tmpPedido=pedido;
			}//if
		return tmpPedido;
	}//updatePedido
	
}//PedidoService
