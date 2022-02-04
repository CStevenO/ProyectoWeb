package com.steven.ProyectoWeb.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steven.ProyectoWeb.modelos.MProfesion;
import com.steven.ProyectoWeb.repositorios.RProfesion;

@Service
public class SProfesion {
	@Autowired
	RProfesion repProfesion;
	
	public MProfesion guardar(MProfesion profesion) {
		return repProfesion.save(profesion);
	}
	
	public Optional<MProfesion> obtenerPorId(int id){
		return repProfesion.findById(id);
	}
	
	public ArrayList<MProfesion> obtenerTodos(){
		return (ArrayList<MProfesion>) repProfesion.findAll();
	}
	
	public boolean eliminar(int id) {
		try {
			repProfesion.deleteById(id);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
