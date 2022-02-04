package com.steven.ProyectoWeb.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steven.ProyectoWeb.modelos.MAspirante;
import com.steven.ProyectoWeb.repositorios.RAspirante;

@Service
public class SAspirante {
	@Autowired
	RAspirante repAspirante;
	
	public MAspirante guardar(MAspirante aspirante) {
		return repAspirante.save(aspirante);
	}
	
	public Optional<MAspirante> obtenerPorId(Long id){
		return repAspirante.findById(id);
	}
	
	public ArrayList<MAspirante> obtenerTodos(){
		return (ArrayList<MAspirante>) repAspirante.findAll();
	}
	
	public boolean eliminar(Long id) {
		try {
			repAspirante.deleteById(id);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<MAspirante> obtenerPorLetra(String letra){
		return repAspirante.findByFirstChar(letra + "%");
	}
	
	public ArrayList<MAspirante> obtenerPorGeneroProfesion(char genero, int idProfesion){
		return repAspirante.findByGenderAndProfession(genero, idProfesion);
	}
	
	public MAspirante obtenerMayor() {
		return repAspirante.findOlder();
	}
	
	public ArrayList<MAspirante> obtenerPorProfesion(int idProfesion){
		return repAspirante.findByProfession(idProfesion);
	}
}
