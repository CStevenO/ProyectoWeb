package com.steven.ProyectoWeb.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.steven.ProyectoWeb.modelos.MAspirante;

public interface RAspirante extends CrudRepository<MAspirante, Long>{

	@Query(value = "SELECT * FROM tb_aspirante u WHERE u.as_nombre LIKE :letra",nativeQuery = true)
	ArrayList<MAspirante> findByFirstChar(@Param("letra") String letra);
	
	@Query(value = "SELECT * FROM tb_aspirante u WHERE u.as_genero = :genero AND u.id_profesion = :id", nativeQuery = true)
	ArrayList<MAspirante> findByGenderAndProfession(@Param("genero") char genero, @Param("id") int id);
	
	@Query(value = "SELECT * FROM tb_aspirante u WHERE u.as_edad = (SELECT MAX(as_edad) FROM tb_aspirante) LIMIT 1", nativeQuery = true)
	MAspirante findOlder();
	
	@Query(value = "SELECT * FROM tb_aspirante u WHERE u.id_profesion = :id", nativeQuery = true)
	ArrayList<MAspirante> findByProfession(@Param("id") int id);
	
}
