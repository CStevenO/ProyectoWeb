package com.steven.ProyectoWeb.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.steven.ProyectoWeb.modelos.MOferta;

public interface ROferta extends CrudRepository<MOferta, Integer>{

	@Query(value = "SELECT * FROM tb_oferta u WHERE NOW() >= u.ofecha_inicio AND NOW() <= u.ofecha_fin", nativeQuery = true)
	ArrayList<MOferta> findBetweenDates();
}
