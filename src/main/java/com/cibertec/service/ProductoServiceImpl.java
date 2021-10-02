package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Producto;
import com.cibertec.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;

	@Override
	public List<Producto> listaAlumno() {
		return repository.findAll();
	}

	@Override
	public Producto insertaActualizaAlumno(Producto obj) {
		return repository.save(obj);
	}

	@Override
	public List<Producto> listaProducto() {
		return null;
	}

}
