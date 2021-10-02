package com.cibertec.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query("Select a from Cliente a where nombre like :fil")
	public abstract List<Cliente> listaClientePorNombreLike(@Param("fil") String filtro);

	@Query("Select x from Cliente x where nombres like :var_filtro or apellidos like :var_filtro")
	public abstract List<Cliente> listaClientePorNombre2(@Param("var_filtro") String filtro, Pageable pageable);
}