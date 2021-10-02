package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Producto;

public interface ProductoService {


		public abstract List<Producto> listaAlumno();

		public abstract Producto insertaActualizaAlumno(Producto obj);

		public abstract List<Producto> listaProducto();

	}



