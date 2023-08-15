package com.cibertec.cl3jeanmaguina.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.cl3jeanmaguina.business.ProductoService;
import com.cibertec.cl3jeanmaguina.model.ProductoModel;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProductoControlador {

	private ProductoService service;
	
	@GetMapping("/") //localhost:9000/
	public String listadoProductos(Model model) {
		model.addAttribute("listaProductos", service.listarProducto());
		return "index";
	}
	
	@GetMapping("/nuevoProducto") //localhost:9000/nuevoProducto
	public String registroProductoFormulario(Model model) {
		ProductoModel producto = new ProductoModel();
		model.addAttribute("producto", producto);
		return "registroProducto";
	}
	
	@PostMapping("/guardarProducto")
	public String registroProducto(@ModelAttribute("producto") ProductoModel producto) {
		service.guardarProducto(producto);
		return "redirect:/";
	}
	
	@GetMapping("/actualizaProducto/{id}") //
	public String actualizaProductoFormulario(@PathVariable(value = "id") int id, Model model) {
		ProductoModel producto = service.listarProductoPorId(id);
		model.addAttribute("producto", producto);
		return "actualizaProducto";
	}
	
	@GetMapping("/eliminarProducto/{id}") //localhost:9000/eliminarProducto/1
    public  String eliminaProducto(@PathVariable(value = "id") int id) {
		service.eliminarProducto(id);
		return "redirect:/";
	}
}
