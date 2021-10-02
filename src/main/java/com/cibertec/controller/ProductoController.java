package com.cibertec.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Producto;
import com.cibertec.service.ProductoService;
import com.cibertec.util.Constantes;

@RestController
@RequestMapping("/rest/producto")
@CrossOrigin(origins = "http://localhost:4200")

public class ProductoController {
	@Autowired
	private ProductoService ProductoService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Producto>> listaProducto() {
		List<Producto> lista = ProductoService.listaProducto();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaAProducto(@RequestBody Producto obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Producto objSalida = ProductoService.insertaActualizaAlumno(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
