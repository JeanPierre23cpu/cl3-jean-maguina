package com.cibertec.cl3jeanmaguina.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.cl3jeanmaguina.business.ProductoService;
import com.cibertec.cl3jeanmaguina.dao.ProductoRepository;
import com.cibertec.cl3jeanmaguina.model.ProductoModel;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

	private ProductoRepository repository; 
	@Override
	public List<ProductoModel> listarProducto() {
		return repository.findAll();
	}
	@Override
	public void guardarProducto(ProductoModel producto) {
		repository.save(producto);
	}
	@Override
	public void eliminarProducto(int id) {
		repository.deleteById(id);
		
	}
	@Override
	public ProductoModel buscar(int id) {
		return repository.findById(id).get();
	}
	@Override
	public ProductoModel listarProductoPorId(int id) {
		return repository.findById(id).orElse(null);
	}
}
