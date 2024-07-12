package org.bdebeach.bdebeach.controller;

import java.util.List;

import org.bdebeach.bdebeach.model.Producto;
import org.bdebeach.bdebeach.service.ProductoService;
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
@RequestMapping(path= "/api/productos/")
public class ProductosController {
	/// CRUD  =  Create  -  Read  -  Update  -  Delete
	/// HTTP  =  POST   -   GET   -  PUT    -   DELETE
	private final ProductoService productoService;
	@Autowired
	public ProductosController(ProductoService productoService) {
		this.productoService= productoService;
	}//constructor 
	
	@GetMapping
	public List<Producto> getProducto() {
		return productoService.getAllProducts(); 
	}//getProducto
	
	@GetMapping(path="{prodId}") // http://localhost:8080/api/productos/1
	public Producto getProducto(@PathVariable ("prodId") Long id) {
		return productoService.getProducto(id); 
	}//getProducto
	
	@DeleteMapping(path="{prodId}") //http://localhost:8080/api/productos/1
	public Producto deleteProducto(@PathVariable("prodId") Long id) {
		return productoService.deleteProduct(id);
	}//deleteProducto
	
	@PostMapping //http://localhost:8080/api/productos/
	public Producto addProducto(@RequestBody Producto producto) {
		return productoService.addProduct(producto);
	}//addProduct
	
	@PutMapping(path="{prodId}") //http://localhost:8080/api/productos/1
	public Producto updateProducto(@PathVariable("prodId") Long id, 
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) String descripcion,
			@RequestParam(required=false) String color,
			@RequestParam(required=false) String tallas,
			@RequestParam(required=false) String img,
			@RequestParam(required=false) Double precio) {
		return productoService.updateProduct(id, nombre, descripcion, precio, color, tallas, img);
	}//updateProducto
	
}//ProductosController
