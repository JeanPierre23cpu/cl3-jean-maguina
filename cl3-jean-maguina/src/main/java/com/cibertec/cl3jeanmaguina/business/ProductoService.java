package com.cibertec.cl3jeanmaguina.business;

import java.util.List;

import com.cibertec.cl3jeanmaguina.model.ProductoModel;

public interface ProductoService {
	
	public List<ProductoModel> listarProducto();
	public ProductoModel buscar(int id);
	public ProductoModel listarProductoPorId(int id);
	public void guardarProducto (ProductoModel producto);
	public void eliminarProducto(int id);
	

}
