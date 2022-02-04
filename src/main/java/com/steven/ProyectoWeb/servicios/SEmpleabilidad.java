package com.steven.ProyectoWeb.servicios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steven.ProyectoWeb.modelos.MEmpleabilidad;
import com.steven.ProyectoWeb.repositorios.REmpleabilidad;

@Service
public class SEmpleabilidad {
	@Autowired
	REmpleabilidad repEmpleabilidad;
	
	public MEmpleabilidad guardar(MEmpleabilidad empleabilidad) {
		empleabilidad.seteFecha(new Date(empleabilidad.geteFecha().getTime() + (1000 * 60 * 60 * 24)));
		return repEmpleabilidad.save(empleabilidad);
	}
	
	public Optional<MEmpleabilidad> obtenerPorId(int id){
		return repEmpleabilidad.findById(id);
	}
	
	public ArrayList<MEmpleabilidad> obtenerTodos(){
		return (ArrayList<MEmpleabilidad>) repEmpleabilidad.findAll();
	}
	
	public boolean eliminar(int id) {
		try {
			repEmpleabilidad.deleteById(id);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
